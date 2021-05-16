# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        def helper(ltree: TreeNode,rtree: TreeNode):
            if not ltree and not rtree:
                return True
            if not ltree or not rtree:
                return False
            return ltree.val == rtree.val and helper(ltree.right,rtree.left) and helper(ltree.left,rtree.right)
        return helper(root.left,root.right)