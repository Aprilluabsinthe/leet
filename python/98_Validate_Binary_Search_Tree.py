# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root,low = float('-inf'),upper = float('inf')):
            if not root:
                return True
            if root.val <= low or root.val >= upper:
                return False
            return helper(root.left, low,root.val) and helper(root.right, root.val,upper)
        return helper(root)

    def isValidBST2(self, root: TreeNode) -> bool:
        stack = []
        inorder = float('-inf')
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right

        return True