#  tictoc 


# board 3*3
# 'A', 'B'
# return boolean who wins/ tie

# 3 rows
# 3 cols
# 2 digs


def tictoc(board):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 'A':
                board[i][j] = 1
            elif board[i][j] == 'B':
                board[i][j] = -1
            else: # space
                board[i][j] = 0
    
    def checkRow(r):
        if sum(board[r]) == 3:
            return 'A'
        elif sum(board[r]) == -3:
            return 'B'
        else:
            return 'tie'
    
    def checkCol(c):
        sum = board[0][c] + board[1][c] + board[2][c]
        if sum == 3:
            return 'A'
        elif sum == -3:
            return 'B'
        else:
            return 'tie'
    
    def checkDiag():
        posDiag = board[0][0] + board[1][1] + board[2][2]
        negDiag = board[0][2] + board[1][1] + board[2][0]
        if posDiag == 3 or negDiag == 3:
            return 'A'
        elif posDiag == -3 or negDiag == -3:
            return 'B'
        else:
            return 'tie'

    if any(checkRow(0),checkRow(1),checkRow(2),checkCol(0),checkCol(1),checkCol(2),checkDiag()) == 'A':
        return 'A'
    elif any(checkRow(0),checkRow(1),checkRow(2),checkCol(0),checkCol(1),checkCol(2),checkDiag()) == 'B':
        return 'B'
    else:
        return 'tie'
