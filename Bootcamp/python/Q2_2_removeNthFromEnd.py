class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        fast = head
        slow = head
        dummy = ListNode(-1)
        dummy.next = head
        pre = dummy
        
        for i in range(n-1):
            fast = fast.next
        
        while fast.next:
            fast = fast.next
            slow = slow.next
            pre = pre.next
        
        pre.next = slow.next
        return dummy.next