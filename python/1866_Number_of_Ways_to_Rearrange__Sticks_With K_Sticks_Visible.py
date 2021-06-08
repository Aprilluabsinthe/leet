class Solution:
    def rearrangeSticks(self, n: int, k: int) -> int:
        if k > n:
            return 0
        dp = [[0] * (k+1) for _ in range(n+1)]
        dp[0][0] = 1
        mod = 10 ** 9 + 7
        for i in range(1,n+1):
            for j in range(1,k+1):
                dp[i][j] = dp[i-1][j-1] # j-1 can be seen in previous i-1
                if j <= i-1:
                    dp[i][j] += (i-1) * dp[i-1][j]
                dp[i][j] %= mod
        return dp[-1][-1]
