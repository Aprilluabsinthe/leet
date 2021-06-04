/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode nxt = head.next;
        
        while(cur != null){
            if( cur.val == val){
                pre.next = nxt;
            }
            else{
                pre = cur;
            }
            cur = nxt;
            nxt = (nxt != null) ? nxt.next : null;
        }
        return dummy.next;
    }
}