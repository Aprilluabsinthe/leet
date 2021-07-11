# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        
        slow = fast = head
        while(fast and fast.next):
            slow, fast = slow.next, fast.next.next
        
        prev, cur = None, slow
        while cur:
            cur.next, prev, cur = prev, cur, cur.next
        
        l1, l2 = head, prev
        while l2.next:
            l1.next, l1 = l2, l1.next
            l2.next, l2 = l1, l2.next