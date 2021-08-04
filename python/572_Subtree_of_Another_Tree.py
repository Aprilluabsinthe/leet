# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree1(self, root: TreeNode, subRoot: TreeNode) -> bool:       
        def check(root,subRoot):
            if not root and not subRoot:
                return True
            if not root or not subRoot:
                return False

            if root.val == subRoot.val:    
                leftTree = check(root.left, subRoot.left)
                rightTree = check(root.right, subRoot.right)
                return (leftTree and rightTree)
            return False
        
        def dfs(root,subRoot):
            if not root:
                return False
            return dfs(root.left,subRoot) or dfs(root.right,subRoot) or check(root,subRoot)
        return dfs(root,subRoot)
    
    def isSubtree(self, root,subRoot):
        if not root and not subRoot:
            return True
        if not root or not subRoot:
            return False
        return self.isSameTree(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
        
    def isSameTree(self, root, subRoot):
        if not root and not subRoot:
            return True
        if not root or not subRoot:
            return False
        return root.val == subRoot.val and self.isSameTree(root.left, subRoot.left) and self.isSameTree(root.right, subRoot.right)

            
        