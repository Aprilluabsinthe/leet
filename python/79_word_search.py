class Solution:
    def dfs(self, board: List[List[str]], word: str, index:index, i:index, j:index) -> bool:
        if board[i][j] != word[index]:
            return False
        elif(index == len(word)-1):
            return True
        
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        value = board[i][j]
        res = False
        board[i][j] = "-1"
        for (di, dj) in dirs:
            ii = i + di
            jj = j + dj
            if(ii >= 0 and ii < len(board) and jj >= 0 and jj < len(board[0]) and board[ii][jj]!="-1"):
                res = self.dfs(board, word, index+1, ii, jj)
                if(res):
                    break
        board[i][j] = value
        return res

    def exist(self, board: List[List[str]], word: str) -> bool:
        row = len(board)
        col = len(board[0])
        for i in range(row) :
            for j in range(col):
                if self.dfs(board, word,0,i,j):
                    return True
        return False
