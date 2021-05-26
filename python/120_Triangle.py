class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        layer = len(triangle[-1])
        if layer == 0:
            return 0
        if layer == 1:
            return triangle[0][0]
        
        minn = float('inf')
        
        for i in range(1,layer):
            for j in range(i+1):
                left = triangle[i-1][j-1] if j-1 >= 0 else float('inf')
                middle = triangle[i-1][j] if j <= i-1 else float('inf')
                # right = triangle[i-1][j+1] if j+1 <= i-1 else float('inf')
                triangle[i][j] += min(left,middle)
                if i == layer-1:
                    minn = min(minn,triangle[layer-1][j])
                
        return minn

    def minimumTotal1(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        f = [0] * n
        f[0] = triangle[0][0]

        for i in range(1, n):
            f[i] = f[i - 1] + triangle[i][i]
            for j in range(i - 1, 0, -1):
                f[j] = min(f[j - 1], f[j]) + triangle[i][j]
            f[0] += triangle[i][0]
        
        return min(f)