# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(inStart, inEnd):
            if inStart > inEnd:
                return None

            rootval = postorder.pop()
            root = TreeNode(rootval)
            inRoot = idx_map[rootval]
 
            root.right = helper(inRoot + 1, inEnd)
            root.left = helper(inStart, inRoot - 1)
            return root
        
        idx_map = {val:idx for idx, val in enumerate(inorder)} 
        return helper(0, len(inorder) - 1)
