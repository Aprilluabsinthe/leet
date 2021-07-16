class Solution:
    def rotate1(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        def swap(a,b):
            a ^= b
            b ^= a
            a ^= b
        
        for i in range(n):
            for j in range(i):
                matrix[i][j] ^= matrix[j][i]
                matrix[j][i] ^= matrix[i][j]
                matrix[i][j] ^= matrix[j][i]

        left, right = 0, n-1
        while left < right:
            for i in range(n):
                matrix[i][left] ^= matrix[i][right]
                matrix[i][right] ^= matrix[i][left]
                matrix[i][left] ^= matrix[i][right]
            left += 1
            right -= 1
    
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                matrix[i][j], matrix[n - j - 1][i], matrix[n - i - 1][n - j - 1], matrix[j][n - i - 1] \
                    = matrix[n - j - 1][i], matrix[n - i - 1][n - j - 1], matrix[j][n - i - 1], matrix[i][j]
