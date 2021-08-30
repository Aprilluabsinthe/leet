class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        import collections
        rowMap = collections.defaultdict(set)
        colMap = collections.defaultdict(set)
        blockMap = collections.defaultdict(set)

        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if board[i][j] in rowMap[i] or board[i][j] in colMap[j] or board[i][j] in blockMap[(i//3)*3+j//3]:
                    return False
                rowMap[i].add(board[i][j])
                colMap[j].add(board[i][j])
                blockMap[(i//3)*3+j//3].add(board[i][j])
        
        return True


    def isValidSudoku1(self, board: List[List[str]]) -> bool:

        def rowColIsValid(i,j):
            rowSet = set()
            for k in range(9):
                if board[i][k] != '.':
                    if board[i][k] in rowSet:
                        return False
                    rowSet.add(board[i][k])

            colSet = set()
            for k in range(9):
                if board[k][j] != '.':
                    if board[k][j] in colSet:
                        return False
                    colSet.add(board[k][j])
            return True

        def blockIsValid(i,j):
            blockInRow = i % 3
            blockInCol = j % 3
            indexMap = { 0 : [0,1,2], 1:[3,4,5], 2:[6,7,8]}

            blockSet = set()
            for ii in range( blockInRow * 3 , blockInRow * 3 + 3):
                for jj in range( blockInCol * 3 , blockInCol * 3 + 3):
                    if board[ii][jj] != '.':
                        if board[ii][jj] in blockSet:
                            return False
                        blockSet.add(board[ii][jj])
            return True

        # res = False
        for i in range(9):
            for j in range(9):
                 if not (rowColIsValid(i,j) and blockIsValid(i,j)):
                     return False
        return True

    


        

        

