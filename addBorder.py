def addBorder(picture):
    row = len(picture)
    col = len(picture[0])
    
    res = []
    
    # "*****"
    rowTemp = ""
    for i in range(col+2):
        rowTemp += "*"
    
    res.append(rowTemp)
    
    # "*abc*"
    for j in range(row):
        rowTemp = ""
        rowTemp = "*" + picture[j] + "*"
        res.append(rowTemp)
        
    # "*****"
    rowTemp = ""
    for i in range(col+2):
        rowTemp += "*"
    
    res.append(rowTemp)
    
    return res

def addBorder2(picture)::
    l=len(picture[0])+2
    return ["*"*l]+[x.center(l,"*") for x in picture]+["*"*l]
    
    

