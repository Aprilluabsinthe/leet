# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l1:
            return l2
        if not l2:
            return l1
        dummy = ListNode(-1)
        p1 = l1
        p2 = l2
        p3 = dummy
        
        while p1 and p2:
            p1val = p1.val
            p2val = p2.val
            if p1val <= p2val:
                p3.next = p1
                p1 = p1.next
                p3 = p3.next
            else:
                p3.next = p2
                p2 = p2.next
                p3 = p3.next
        
        if not p1 and not p2:
            return dummy.next
        if p1:
            p3.next = p1
        if p2:
            p3.next = p2
        return dummy.next
            
        