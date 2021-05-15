# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        
        def helper(p: TreeNode, q: TreeNode):
            if (p == None and q == None):
                return True
            if (p == None and q != None) or (p != None and q == None) or (p != None and q != None and p.val != q.val):
                return False
            return helper(p.left,q.left) and helper(p.right,q.right)
        
        return helper(p,q)