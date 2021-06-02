# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        ans = []
        def tranversal(root:TreeNode, level:int):
            if not root:
                return
            if len(ans) == level:
                ans.append([])
            ans[level].append(root.val)
            tranversal(root.left,level+1)
            tranversal(root.right,level+1)
        tranversal(root,0)
        return ans
    
    # the usage of [*ans.values()]? 
    def levelOrder1(self, root: TreeNode) -> List[List[int]]:
        ans = collections.defaultdict(list)
        def tranversal(root:TreeNode, level:int):
            if not root:
                return
            ans[level].append(root.val)
            tranversal(root.left,level+1)
            tranversal(root.right,level+1)
        tranversal(root,0)
        return [*ans.values()]