# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, total: int) -> List[List[int]]:
        paths = list()
        path = list()
        
        def dfs(root: TreeNode, total: int):
            if not root:
                return
            
            path.append(root.val)
            if not root.left and not root.right and total == root.val:
                paths.append(path[:])
            dfs(root.left, total - root.val)
            dfs(root.right, total - root.val)
            path.pop()
        
        dfs(root, total)
        return paths
