"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
import collections
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        if root.left and root.right:
            root.left.next = root.right
        elif root.left and not root.right:
            root.left.next = self.findNext(root.next)
        elif root.right:
            root.right.next = self.findNext(root.next)
        self.connect(root.left)
        self.connect(root.right)
        return root

    def findNext(self,node):
        if not node:
            return None
        if node.left:
            return node.left
        if node.right:
            return node.right
        if node.next:
            return self.findNext(node.next)
        return None
    
    def connect1(self, root: 'Node') -> 'Node':
        if not root:
            return None
        queue = collections.deque([root])
        while queue:
            size = len(queue)
            for i in range(size):
                curNode = queue.popleft()
                curNode.next = queue[0] if i < size -1 else None
                if curNode.left:
                    queue.append(curNode.left)
                if curNode.right:
                    queue.append(curNode.right)
        return root
