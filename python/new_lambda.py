# This function is the lambda integration of an API Gateway POST endpoint. It posts an asset item to the table
# and it gets information from the table via a scan query and getitem.
import base64
import boto3
import json
import datetime
import copy
import uuid
import requests
from blosem.utils import dynamodb as utpdb
from boto3.dynamodb.conditions import Key, Attr
from decimal import Decimal

dynamo = boto3.resource('dynamodb')
lambda_client = boto3.client('lambda')

def build_return(code, job_id, result, ret_value):
    ret = {'statusCode': code, 'body': json.dumps({'job_id': job_id, 'result': result, 'return_value': ret_value})}
    return ret

def default_type_error_handler(obj):
    if isinstance(obj, Decimal):
        return int(obj)
    raise TypeError

def lambda_handler(event, context):
    table = dynamo.Table("BLOSEM_Operational_Asset")
    verify_table = dynamo.Table('BLOSEM_Asset_Verify')

    # print(event['isBase64Encoded'])
    # if event['isBase64Encoded']:
    #     payload = base64.b64decode(event['body'])
    # else:
    #     payload = event['body']
    # data = json.loads(payload)
    
    # print("Event",event)
    payload = event['body']
    print("payload",payload)
    data = payload
    result = ""
    
    
    # to post item to table
    if 'entry_data' in data:
        data = data['entry_data']
        keys = data.keys()

        for i in keys:
            k = i.split("_")
            if k[1] == 'Operation':
                gen_item = data['inputFields_Operation'][0]
                
                gen_item['ops_manual_uuid'] = data['inputFields_OpsManual'][0]['uuid']
                gen_item['hash'] = 'N/A' 
                gen_item['created_ts'] = str(datetime.datetime.now()) # utc
    
                response = table.put_item(
                    Item=gen_item
                )
    
                result = {
                    "job_id": "operations-" + response['ResponseMetadata']['RequestId'],
                    "success": True,
                    "result": "Item posted, uuid: " + gen_item['uuid'],
                    "return_value": [ {"timestamp":str(datetime.datetime.now())} ]
                }
                
                if response['ResponseMetadata']['HTTPStatusCode'] != 200:
                    result = {
                        "success": False,
                        "result": 'Error: Operations asset not uploaded.'
                    }
                    
                return {
                    'statusCode': response['ResponseMetadata']['HTTPStatusCode'],
                    'body': json.dumps(result)
                }

            elif k[1] == 'OpsManual':
                payloadJSON = json.dumps(data['inputFields_OpsManual'][0])
                try:
                    response = lambda_client.invoke(
                        FunctionName = '',
                        InvocationType = 'RequestResponse',
                        Payload = payloadJSON,
                    )
                except Exception:
                    result = {
                        "success": False,
                        "result": 'Error: Ops manual not uploaded.'
                    }
                    return {
                        'statusCode': response['StatusCode'],
                        'body': json.dumps(result)
                    }
                    
            elif k[1] == 'Order':  # GRJ: added to test concept of ordering an asset
                job_id = str(uuid.uuid4())
                ret_value = []
                catalog_table = dynamo.Table("BLOSEM_Catalogue_Assets")
                instructions_table = dynamo.Table("BLOSEM_Instructions")
                manual_table = dynamo.Table("BLOSEM_Ops_Manuals")
                catalog_items = data['inputFields_Order']
                for item_uuid in catalog_items:
                    # Query Catalog Assets Table for full context using item_uuid
                    catalog_res = catalog_table.query(
                            KeyConditionExpression=Key('uuid').eq(item_uuid)
                        )
                    if catalog_res['ResponseMetadata']['HTTPStatusCode'] != 200:
                        return build_return(response['ResponseMetadata']['RequestId'], job_id, False, f'Error: Failed to read {item_uuid} from Catalog.')
                        
                    catalog_item = catalog_res['Items'][0]
                    gen_item = copy.deepcopy(catalog_item)
                    
                    instr_uuid = gen_item['instructions_uuid']
                    instructions_res = instructions_table.query(
                            KeyConditionExpression=Key('uuid').eq(instr_uuid)
                        )
                    if instructions_res['ResponseMetadata']['HTTPStatusCode'] != 200:
                        return build_return(instructions_res['ResponseMetadata']['RequestId'], job_id, False, f'Error: Failed to read {instr_uuid} from Instructions.')
                    instr_item = copy.deepcopy(instructions_res['Items'][0])
                    instr_item['uuid'] = str(uuid.uuid4())
                    instr_post_res = manual_table.put_item(
                        Item=instr_item
                    )
                    if instr_post_res['ResponseMetadata']['HTTPStatusCode'] != 200:
                        return build_return(instr_post_res['ResponseMetadata']['RequestId'], job_id, False, f'Error: Failed to publish {instr_item["uuid"]} to Instructions.')
                    
                    gen_item['catalog_asset_uuid'] = gen_item['uuid']
                    gen_item['uuid'] = str(uuid.uuid4())
                    gen_item['created_ts'] = str(datetime.datetime.now()) # utc
                    gen_item['modified_ts'] = str(datetime.datetime.now()) # utc
                    gen_item['status'] = 'Ordered'
                    gen_item['instructions_uuid'] = instr_item['uuid']
                    # TODO: delete keys -> existing, orderable
                    # print(gen_item)
                    # TODO: Copy all of HBOM and SBOM entries too?
                    response = table.put_item(
                        Item=gen_item
                    )
    
                    res_code = response['ResponseMetadata']['HTTPStatusCode']
                    if res_code != 200:
                        return build_return(res_code, job_id, False, f'Error: Operations asset {item_uuid} not published.')
                    ret_value.append({"uuid": gen_item['uuid'], "timestamp":str(datetime.datetime.now())})
                
                return build_return(200, job_id, True, ret_value)
                
    # to get information from table
    elif 'action' in data:
        act = data['action']
        print(act)
        if act == "scan":
            scan_count = 1000 if 'count' not in data else int(data['count'])
            scanned = table.scan( Limit=scan_count )
            items = scanned['Items']
            
            # operations: =, <, >
            if 'custom_filters' in data:
                final = []
                
                for i in items:
                    for c in data['custom_filters']:
                        filter = c['field']
                        op = c['operation']
                        val = c['value']
                        if op == '=':
                            if str(i[filter]).lower() == val.lower():
                                final.append(i)
                        elif op == '>':
                            if i[filter] > val:
                                final.append(i)
                        elif op == '<':
                            if i[filter] < val:
                                final.append(i)

                    # if start_time is specified, use query?
                    if 'start_time' in data and data['start_time'] and 'end_time' in data and data['end_time']:
                        start = time.mktime(datetime.datetime.strptime(data['start_time'], "%Y-%m-%d %H:%M:%S").timetuple())
                        end = time.mktime(datetime.datetime.strptime(data['end_time'], "%Y-%m-%d %H:%M:%S").timetuple())
                        temp = i['created_ts'].split('.')
                        created = time.mktime(datetime.datetime.strptime(temp[0], "%Y-%m-%d %H:%M:%S").timetuple())
                        if created - start > 0 and end - created > 0:
                            final.append(i)
            else: 
                final = items
            if final:
                result = {
                    "job_id": "operations-" + scanned['ResponseMetadata']['RequestId'],
                    "success": True,
                    "result": final,
                    "return_value": [ {"timestamp":str(datetime.datetime.now())} ]
                }
            else: 
                result = {
                    "job_id": "operations-" + scanned['ResponseMetadata']['RequestId'],
                    "success": False,
                    "result": final,
                    "return_value": [ {"timestamp":str(datetime.datetime.now())} ]
                }
            print("result",result)
            return {
                    'statusCode': 200,
                    'body': json.dumps(result,default=default_type_error_handler)
                }
            
        # only get item by uuid
        elif act == "asset":
            v = data['custom_filters'][0]
            try:
                item = table.query(
                    KeyConditionExpression="#field" + v['operation'] + ":val",
                    ExpressionAttributeNames={ "#field": v['field'] },
                    ExpressionAttributeValues={ ":val": v['value'] }
                )
                result = {
                    "job_id": "operations-" + item['ResponseMetadata']['RequestId'],
                    "success": True,
                    "result": item['Items'],
                    "return_value": [ {"timestamp":str(datetime.datetime.now())} ]
                }
                return {
                    'statusCode': 200,
                    'body': json.dumps(result)
                }
            except ValueError:
                result = {
                    "success": False,
                    "result": 'UUID does not match with any existing'
                }
                return {
                    'statusCode': 500,
                    'body': json.dumps(result)
                }

        elif act == "query":  # GRJ: added to test concept of querying assets
            job_id = str(uuid.uuid4())
            #  Parse body parameters
            try:
                return_fields = ['uuid', 'name', 'version', 'hw_part_number', 'vendor', 'onchain', 'status']
                scan_count = 1000 if 'count' not in data else int(data['count'])
                custom_filters = [] if 'custom_filters' not in data else data['custom_filters']
                select_fields = return_fields if 'select_fields' not in data else data['select_fields']
            except Exception as e:
                print(f'Request failed {e}')
                return build_return(400, job_id, False, f'Error occurred with input body ')
            
            # Upon request, pull UUIDs from Fabric ledger
            chain_list = []
            if 'onchain' in select_fields:
                try:
                    r = requests.get('https://operations-api.a9srb53aqkp.us-south.codeengine.appdomain.cloud/operations/api/v1/read/all', headers = {"x-api-key-id": "2674cc0d-36af-dfd5-4f1b-dc6edc67cff9"}) 
                    if r.status_code == 200:
                        for a in r.json():
                            chain_list.append(a['Key'])
                    else:
                        print(f'Blockchain query failed {r.status_code}')
                    # print(chain_list)
                except Exception as e:
                    print(f'Server failed {e}')
                    # return build_return(500, job_id, False, f'Error occurred with server {e}')
            
            try:
                attempt = ''
                if 'vendor' in select_fields:
                    select_fields.append('vendor_uuid')
                res, return_value = utpdb.table_query(table, scan_count, custom_filters, select_fields)
                if res:
                    chain_check = False
                    if 'vendor' in select_fields:
                        for i in return_value:
                            vendor_name = 'Not set'
                            vendor_uuid = 'Not set' if 'vendor_uuid' not in i else i['vendor_uuid']
                            attempt = str(i) + " " + vendor_uuid
                            vendor_table = dynamo.Table("BLOSEM_Vendors")
                            if vendor_uuid != 'Not set':
                                vendor_res = vendor_table.query(
                                    KeyConditionExpression=Key('uuid').eq(vendor_uuid)
                                )
                                vendor_ret = vendor_res['Items']
                                vendor_name = vendor_uuid if 'name' not in vendor_ret[0] else vendor_ret[0]['name']
                            i['vendor'] = vendor_name
                            
                            if 'onchain' in select_fields:
                                chain_check = True
                                i['onchain'] = 'False'
                                if i['uuid'] in chain_list:
                                    i['onchain'] = 'True'
                    
                    if 'onchain' in select_fields and chain_check == False:
                        for i in return_value:
                            i['onchain'] = 'False'
                            if i['uuid'] in chain_list:
                                i['onchain'] = 'True'
                    
                    return build_return(200, job_id, res, return_value)
                else:
                    return build_return(500, job_id, res, f'Error occurred reading Operations Assets {ret_value}')
            except Exception as e:
                print(f'Server failed {e}')
                print(f'Failed on {attempt}')
                return build_return(500, job_id, False, f'Error occurred with server {e}')
    
        elif act == "init_verify":
            job_id = str(uuid.uuid4())
            #  Parse body parameters
            asset_uuid_list = [] if 'item' not in data else data['item']
            if 'item' not in data:
                return build_return(400, job_id, False, f'Error occurred with input body - not item list')
            for a in asset_uuid_list:
                item_key = a['value']
                ops_status = 'Pending'
                res = verify_table.update_item(
                    Key={
                        'asset_uuid': item_key,
                        'status': 'Installed'
                    },
                    UpdateExpression="set ops_status=:v",
                    ExpressionAttributeValues={
                        ':v': ops_status
                    }
                )
                # print(res)
                res_code = res['ResponseMetadata']['HTTPStatusCode']
                if res_code != 200:
                    return build_return(res_code, job_id, False, f'Failed to query installation site {a["value"]}')
                
                try:
                    data = {"uuid": item_key}
                    r = requests.post('https://operations-api.a9srb53aqkp.us-south.codeengine.appdomain.cloud/operations/api/v1/verify/initiate', 
                                      headers = {"x-api-key-id": "2674cc0d-36af-dfd5-4f1b-dc6edc67cff9"},
                                      data = data) 
                    if r.status_code != 200:
                        print(f'Blockchain trigger failed for {item_key} with {r.status_code}')
                        return build_return(500, job_id, False, f'Blockchain trigger failed for {item_key} with {r.status_code}')
                except Exception as e:
                    print(f'Blockchain trigger failed for {item_key} with {e}')
                    return build_return(500, job_id, False, f'Blockchain trigger failed for {item_key} with {e}')
        # elif act == "detail":
        #     try:
        #         attempt = ''
        #         table = dynamo.Table("BLOSEM_Catalogue_Assets")
        #         if 'vendor' in select_fields:
        #             select_fields.append('vendor_uuid')
        #         # Get all values from BLOSEM_Catalogue_Assets based on the custom
        #         res, return_value = utpdb.table_query(table, scan_count, custom_filters, select_fields)
        #         if res:
        #             if 'vendor' in select_fields or 'onchain' in select_fields or 'sw_author' in select_fields:
        #                 if 'onchain' in select_fields:
        #                     chain_list = []
        #                     try:
        #                         r = requests.get('https://manufacturer-api.a9srb53aqkp.us-south.codeengine.appdomain.cloud/catalog/api/v1/read/all', headers = {"x-api-key-id": "f0a8bf77-5e3b-985d-90da-227dfef74efc"}) 
        #                         if r.status_code == 200:
        #                             for vuln in r.json():
        #                                 chain_list.append(vuln['Key'])
        #                         else:
        #                             print(f'Blockchain query failed {r.status_code}')
        #                         # print(chain_list)
        #                     except Exception as e:
        #                         print(f'Server failed {e}')    
                                
        #                 # i = return_value[0]
        #                 for i in return_value:
        #                     vendor_name = 'Not set'
        #                     vendor_uuid = 'Not set' if 'vendor_uuid' not in i else i['vendor_uuid']
        #                     attempt = str(i) + " " + vendor_uuid
        #                     if vendor_uuid != 'None' and vendor_uuid != 'Not set':
        #                         vendor_res = vendor_table.query(
        #                             KeyConditionExpression=Key('uuid').eq(vendor_uuid)
        #                         )
        #                         vendor_ret = vendor_res['Items']
        #                         vendor_name = vendor_uuid if 'name' not in vendor_ret[0] else vendor_ret[0]['name']
        #                     i['vendor'] = vendor_name
                            
        #                     if 'sw_author' in select_fields:
        #                         sw_author = 'Not set'
        #                         sw_author_uuid = 'Not set' if 'sw_author' not in i else i['sw_author']
        #                         attempt = str(i) + " " + sw_author_uuid
        #                         if sw_author_uuid != 'None' and sw_author_uuid != 'Not set' :
        #                             sw_author_res = vendor_table.query(
        #                                 KeyConditionExpression=Key('uuid').eq(sw_author_uuid)
        #                             )
        #                             sw_author_ret = sw_author_res['Items']
        #                             sw_author = sw_author_uuid if 'name' not in sw_author_ret[0] else sw_author_ret[0]['name']
        #                         i['sw_author'] = sw_author
                            
        #                     # Get onchain status for the asset
        #                     if 'onchain' in select_fields:
        #                         i['onchain'] = 'False'
        #                         if i['uuid'] in chain_list:
        #                             i['onchain'] = 'True'
        #         else:
        #             return build_return(500, job_id, res, return_value)
                
    result = {
        "success": True,
        "result": "Uploaded"
    }        
    return {
        'statusCode': 200,
        'body': json.dumps(result)
    }