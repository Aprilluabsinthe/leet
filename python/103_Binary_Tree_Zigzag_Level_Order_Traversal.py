# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # recursive
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
    
    # DFS
    def zigzagLevelOrderDFS(self, root: Optional[TreeNode]) -> List[List[int]]:
        from collections import deque
        if not root:
            return root
        res = []
        
        def dfs(node,level):
            if level >= len(res):
                res.append(deque([node.val]))
            else:
                if level % 2 == 0:
                    # left->right, normal order
                    res[level].append(node.val)
                else:
                    res[level].appendleft(node.val)
            if node.left:
                dfs(node.left,level+1)
            if node.right:
                dfs(node.right,level+1)
        dfs(root,0)
        return res
        
    # BFS 
    def zigzagLevelOrderBFS(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return root
        
        q = collections.deque()
        ans = []
        q.append(root)
        flip = True
        
        while q:
            level = collections.deque()
            lenq = len(q)
            i = 0
            flip = not flip   # next level
            while i < lenq:
                curNode = q.popleft()
                if curNode.left:
                    q.append(curNode.left)
                if curNode.right:
                    q.append(curNode.right)
                if not flip:
                    level.append(curNode.val)
                else:
                    level.appendleft(curNode.val)
                i += 1
            ans.append(level)
        return ans

