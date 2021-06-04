# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        dummy = ListNode(0,head)
        node, last = head, dummy
        while node:
            if node.val == val:
                last.next = node.next
            else:
                last = last.next
            node = node.next
        return dummy.next