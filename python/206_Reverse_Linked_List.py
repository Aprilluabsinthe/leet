# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        if head.next is None:
            return head
        
        pre = None
        cur = head
        nxt = cur.next
        
        while cur:
            cur.next = pre
            pre = cur
            cur = nxt
            nxt = nxt.next if nxt else None
        
        return pre
        