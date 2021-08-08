# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        if not root:
            return [0]
        
        from collections import deque
        q = deque()
        q.append(root)
        
        res = []
        while q: # 3
            levelSum = 0 
            levelLen = len(q) #1
            # in each level
            i = 0
            while i < levelLen:
                curNode = q.popleft() # 3
                if curNode.left: 
                    q.append(curNode.left)# [9]
                if curNode.right:
                    q.append(curNode.right) # [9,20]
                levelSum += curNode.val # 3
                i += 1
            
            res.append(levelSum / levelLen)
        return res
            
            
        