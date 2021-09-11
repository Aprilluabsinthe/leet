def matrixElementsSum(matrix):
    row = len(matrix)
    col = len(matrix[0])
    
    allSum = 0
    for j in range(col):
        colSum = 0
        for i in range(row):
            if matrix[i][j] != 0:
                colSum += matrix[i][j]
            else:
                break
        allSum += colSum
                
    return allSum
            

