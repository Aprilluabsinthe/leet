class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        row = len(matrix)
        col = len(matrix[0])
        maxK = row * col
        if k > maxK:
            return 0
        
        xorlist = [[0 for i in range(col)] for _ in range(row)]
        anslist = []
        for i in range(row):
            for j in range(col):
                if i == 0 and j == 0:
                    xorlist[i][j] = matrix[i][j]
                    anslist.append(xorlist[i][j])
                elif i == 0:
                    xorlist[i][j] = matrix[i][j] ^ xorlist[i][j-1]
                    anslist.append(xorlist[i][j])
                elif j == 0:
                    xorlist[i][j] = matrix[i][j] ^ xorlist[i-1][j]
                    anslist.append(xorlist[i][j])
                else:
                    xorlist[i][j] = matrix[i][j] ^ xorlist[i-1][j] ^ xorlist[i][j-1] ^ xorlist[i-1][j-1]
                    anslist.append(xorlist[i][j])
        
        anslist.sort()
        return anslist[-1*k]