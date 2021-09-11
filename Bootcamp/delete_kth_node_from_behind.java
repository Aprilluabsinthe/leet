public class delete_kth_node_from_behind {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode getKthFromEnd(ListNode head, int k) {
        // slow and fast pointers
        // 1 2 3 4 5 null
        // |   |
        //   |    | 
        //.    |   |
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while(i < k){
            fast = fast.next;
            i++;
        }

        while(fast != null ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
