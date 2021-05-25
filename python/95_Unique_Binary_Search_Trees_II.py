# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        def helper(start,end):
            if start > end:
                return [None,]
            allTrees = []
            for i in range(start, end+1):
                leftTrees = helper(start, i-1)
                rightTrees = helper(i+1, end)
                for l in leftTrees:
                    for r in rightTrees:
                        currTree = TreeNode(i)
                        currTree.left = l
                        currTree.right = r
                        allTrees.append(currTree)
            return allTrees
        
        return helper(1,n)