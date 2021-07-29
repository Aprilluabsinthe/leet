# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0

        def dfs(root,preTotal):
            if not root:
                return 0
        
            total = preTotal * 10 + root.val
            if not root.left and not root.right:
                return total
            else:
                return dfs(root.left, total) + dfs(root.right, total)
        return dfs(root,0)

    def sumNumbers_bfs(self, root: TreeNode) -> int:
        root_to_leaf = 0
        stack = [(root,0)]
        while stack:
            root, curr_number = stack.pop()
            if root:
                curr_number = curr_number * 10 + root.val
                if not root.left and not root.right:
                    root_to_leaf += curr_number
                else:
                    stack.append((root.left,curr_number))
                    stack.append((root.right,curr_number))
        
        return root_to_leaf