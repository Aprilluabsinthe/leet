/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
 var getIntersectionNode = function(headA, headB) {
    let ptrA = headA;
    let ptrB = headB;
    while(ptrA != ptrB){
        ptrA = (ptrA!=null)?ptrA.next:headB;
        ptrB = (ptrB!=null)?ptrB.next:headA;
    }
    return ptrA;
};