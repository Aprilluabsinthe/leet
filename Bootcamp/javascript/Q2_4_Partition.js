/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
 var partition = function(head, x) {
    let sm = new ListNode();
    let smptr = sm;
    let lg = new ListNode();
    let lgptr = lg;
    
    let ptr = head;
    while(ptr!=null){
        if(ptr.val < x){
            smptr.next = ptr;
            smptr = smptr.next;
        }else{
            lgptr.next = ptr;
            lgptr = lgptr.next;
        }
        let temp = ptr;
        ptr = ptr.next;
        temp.next = null;
    }
    
    smptr.next = lg.next;
    return sm.next;
};