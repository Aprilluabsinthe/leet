# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        slow = head
        fast = head
        hasCircle = False
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                hasCircle = True
                break
        
        if not hasCircle:
            return None
        # has cycle
        print(fast.val)
        
        
        fast = head
        k = 0
        while fast!=slow:
            fast = fast.next
            slow = slow.next
        return fast
        