class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        ans = ""
        for length in range(n): # 0,1,2,3,4
            for start in range(0,n-length,1): # 0,1,2,3,4
                end = start + length # [start,end]
                if length == 0:
                    dp[start][end] =  True
                elif length == 1:
                    dp[start][end] =  (s[start] == s[end])
                else:
                    dp[start][end] =  (s[start] == s[end] and dp[start+1][end-1])
                if dp[start][end] and length + 1 > len(ans):
                    ans = s[start:end+1]
        return ans