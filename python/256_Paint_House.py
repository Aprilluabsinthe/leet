class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return None
        houseLen = len(costs)
        colorLen = 3
        dp = [[float('inf')] * colorLen for _ in range(houseLen)]
        dp[0] = costs[0]
        
        for i in range(1,houseLen):
            dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + costs[i][0]
            dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + costs[i][1]
            dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + costs[i][2]
        
        return min(dp[houseLen-1])
