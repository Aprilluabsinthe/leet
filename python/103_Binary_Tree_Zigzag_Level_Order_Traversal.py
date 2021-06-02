# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        def tranversal(root:TreeNode, level:int):
            if not root:
                return
            if len(res) == level:
                res.append(list())

            if( level % 2 == 0):
                res[level].append(root.val)
            else:
                res[level].insert(0,root.val)
            tranversal(root.left,level+1)
            tranversal(root.right,level+1)
        tranversal(root,0)
        return res

