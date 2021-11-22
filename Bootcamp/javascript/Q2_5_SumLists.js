/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
 var addTwoNumbers = function(l1, l2) {
    let ptr1 = l1;
    let ptr2 = l2;
    let carry = 0;
    let dummy = new ListNode(-1);
    let ans = dummy;
    while(ptr1!=null || ptr2!=null){
        let val1 = (ptr1!=null) ? ptr1.val:0;
        let val2 = (ptr2!=null) ? ptr2.val:0;
        let summ = (val1 + val2 + carry);
        carry = Math.floor(summ / 10);
        let nodeVal = summ % 10;
        ans.next = new ListNode(nodeVal);
        ans = ans.next;
        ptr1 = (ptr1!=null) ? ptr1.next:null;
        ptr2 = (ptr2!=null) ? ptr2.next:null;
    }
    
    if(carry != 0) ans.next = new ListNode(carry);
    
    return dummy.next;
};