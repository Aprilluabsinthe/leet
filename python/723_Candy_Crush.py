class Solution:

    def candyCrush(self, board):
        R, C = len(board), len(board[0])
        todo = False

        for r in range(R):
            for c in range(C-2):
                if abs(board[r][c]) == abs(board[r][c+1]) == abs(board[r][c+2]) != 0:
                    board[r][c] = board[r][c+1] = board[r][c+2] = -abs(board[r][c])
                    todo = True

        for r in range(R-2):
            for c in range(C):
                if abs(board[r][c]) == abs(board[r+1][c]) == abs(board[r+2][c]) != 0:
                    board[r][c] = board[r+1][c] = board[r+2][c] = -abs(board[r][c])
                    todo = True

        # for c in range(C):
        #     low = R-1
        #     high = R-1
        #     while low >=0 and high >= 0:
        #         while low >= 0 and board[low][c] > 0:
        #             low -= 1
        #         while high >= 0 and board[high][c] < 0:
        #             high -= 1
        #         if low >= 0 and high >= 0:
        #             board[low][c] = board[high][c]
        #             board[high][c] = 0

        for c in range(C):
            low = R-1
            for r in range(R-1, -1,-1):
                if board[r][c] > 0:
                    board[low][c] = board[r][c]
                    low -= 1
            for low in range(low,-1,-1):
                board[low][c] = 0

        return self.candyCrush(board) if todo else board


    def candyCrush1(self, board: List[List[int]]) -> List[List[int]]:
        row = len(board)
        col = len(board[0])

        colsToDeal = set()
        crush = False

        # row
        for i in range(row):
            for j in range(col-2):
                temp = board[i][j]
                if(board[i][j] == board[i][j+1] == board[i][j+2]):
                    crush = True
                    board[i][j] = board[i][j+1] = board[i][j+2] = 0
                    colsToDeal.add(j)
                    colsToDeal.add(j+1)
                    colsToDeal.add(j+2)
        
        # col
        for i in range(row-2):
            for j in range(col):
                temp = board[i][j]
                if(board[i][j] == board[i+1][j] == board[i+2][j]):
                    crush = True
                    board[i][j] = board[i+1][j] = board[i+2][j] = 0
                    colsToDeal.add(j)
        
        # fall
        for c in colsToDeal:
            high = row-1
            low = row-1
            while(low >= 0 and high >= 0):
                while(low >= 0 and board[low][c] != 0):
                    low -= 1
                while(high >= 0 and board[high][c] == 0):
                    high -= 1
                if high >= 0 and low >= 0:
                    board[low][c] = board[high][c]
                    board[high][c] = 0
            


        return self.candyCrush(board) if crush else board



