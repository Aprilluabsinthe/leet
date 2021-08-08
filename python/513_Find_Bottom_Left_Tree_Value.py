# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        q = collections.deque()
        q.append(root)
        curNode = root
        
        while q:
            curNode = q.popleft()
            if curNode.right :
                q.append(curNode.right)
            if curNode.left:
                q.append(curNode.left)
        return curNode.val
            
        