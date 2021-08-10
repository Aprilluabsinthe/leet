# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        k = len(lists)
        import heapq
        q = []
        
        setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
        # setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
        
        for lst in lists:
            while lst:
                heapq.heappush(q,lst)
                lst = lst.next
        
        dummy = ListNode(-1)
        res = dummy
        while q:
            res.next = heapq.heappop(q)
            res = res.next
        return dummy.next