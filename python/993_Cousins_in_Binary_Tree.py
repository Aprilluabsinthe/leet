# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        queue = [root]

        while queue:
            size = len(queue)
            cur_level = []
            for _ in range(size):
                top = queue.pop(0)
                if top:
                    cur_level.append(top.val)
                    queue.append(top.left)
                    queue.append(top.right)
                else:
                    cur_level.append(-1)
            
            if x in cur_level and y in cur_level:
                index1 = cur_level.index(x)
                index2 = cur_level.index(y)
                if index1 > index2:
                    index1,index2 = index2, index1
                if index1 + 1 == index2 and index1 & 1 == 0:
                    return False
                return True
            
            if x in cur_level or y in cur_level:
                return False
            
        return False


        