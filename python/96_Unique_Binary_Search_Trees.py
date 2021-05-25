class Solution:
    def numTrees(self, n: int) -> int:
        dp = [1] * 2 + [0] * (n+1)
        for i in range(2,n+1):
            for j in range(1,i+1):
                dp[i] += dp[j-1] * dp[i-j]
        return dp[n]