class Solution(object):
    def rob(self,slices, N):
        lenth = len(slices)
        dp = [[0] * (N+1) for _ in range(lenth+2)]
        for i,num in enumerate(slices,2):
            for j in range(1,N+1):
                dp[i][j] = max( dp[i-2][j-1] + num, dp[i-1][j])
        return dp[-1][N]

    def maxSizeSlices(self, slices):
        """
        :type slices: List[int]
        :rtype: int
        """
        N = (len(slices)) // 3
        return max(self.rob(slices[1:],N), self.rob(slices[:-1],N))
