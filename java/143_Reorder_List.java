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
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        if (head.next == null){
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }
    
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode nxt;
        while(cur!=null){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
    
    public void mergeList(ListNode first,ListNode second){
        ListNode first_temp;
        ListNode second_temp;
        while(first != null && second != null){
            first_temp = first.next;
            second_temp = second.next;
            first.next = second;
            second.next = first_temp;
            
            first = first_temp;
            second = second_temp;
        }
    }
}