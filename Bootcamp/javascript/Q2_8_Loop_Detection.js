/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */

 var hasCycle = function(head) {
    let slow = head;
    let fast = head;
    
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow === fast){
            return slow;
        }
    }
    return null;
};

var detectCycle = function(head) {
    let incircle = hasCycle(head);
    if(incircle === null){
        return null;
    }
    let ptr1 = head;
    let ptr2 = incircle;
    while(ptr1 !== ptr2){
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
    }
    return ptr2;
    
};