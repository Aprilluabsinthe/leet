# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.firstNode = None
        self.secondNode = None
        self.preNode = TreeNode(float("-inf"))

        def inorder(root):
            if not root:
                return None
            
            inorder(root.left)
            
            if self.firstNode == None and self.preNode.val >= root.val:
                self.firstNode = self.preNode
            if self.firstNode and self.preNode.val >= root.val:
                self.secondNode = root

            self.preNode = root
            inorder(root.right)

        inorder(root)
        self.firstNode.val, self.secondNode.val = self.secondNode.val, self.firstNode.val