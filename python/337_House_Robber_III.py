# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rob(self, root: TreeNode) -> int:
        memo = {}
        
        def robHelper(root,memo):
            if not root:
                return 0
            if root in memo:
                return memo[root]

            notSelected = robHelper(root.left,memo) + robHelper(root.right,memo)
            selected = root.val
            selected += ( robHelper(root.left.left,memo) + robHelper(root.left.right,memo) ) if root.left != None else 0;
            selected += ( robHelper(root.right.left,memo) + robHelper(root.right.right,memo) ) if root.right != None else 0
            ans = max(selected,notSelected)
            memo[root] = ans
            return ans
        
        def robCompress(root):
            if not root:
                return 0,0
            left_not_select,left_select = robCompress(root.left)
            right_not_select,right_select = robCompress(root.right)
            
            root_not_select = max(left_not_select,left_select) + max(right_not_select,right_select)
            root_select = root.val + left_not_select + right_not_select
            return root_not_select,root_select
        
        # return robHelper(root,memo)
        return max(robCompress(root))