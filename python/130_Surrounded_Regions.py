class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        
        row , col = len(board) , len(board[0])
        
        def dfs(x,y): 
            # mark all egde 'O's as 'A'
            if(x < 0 or x >= row or y < 0 or y >= col):
                return
            if board[x][y] != 'O':
                return
            
            dx = [0,1,0,-1]
            dy = [1,0,-1,0]
            board[x][y] = 'A'
            
            for i in range(4):
                dfs(x+dx[i],y+dy[i])
        
        def bfs(x,y):
            from collections import deque
            queue = deque()
            queue.append((x,y))
            while queue:
                # mark all egde 'O's as 'A'
                (x,y) = queue.pop()
                if(x < 0 or x >= row or y < 0 or y >= col):
                    continue
                if board[x][y] != 'O':
                    continue

                dx = [0,1,0,-1]
                dy = [1,0,-1,0]
                board[x][y] = 'A'

                for i in range(4):
                    queue.append((x+dx[i],y+dy[i]))
        
        for i in range(row):
            bfs(i,0)
            bfs(i,col-1)
        
        for i in range(col):
            bfs(0,i)
            bfs(row-1,i)
        
        for x in range(row):
            for y in range(col):
                if board[x][y] == 'A':
                   board[x][y] = 'O'
                elif board[x][y] == 'O':
                   board[x][y] = 'X'
        