class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        return self.maxProfit2(prices)

    # compress space
    def maxProfit2(self, prices: List[int]) -> int:
        if not prices:
            return 0

        days = len(prices)
        if days == 0 or days == 1:
            return 0
        
        minn = prices[0]
        maxx = 0
        for i in range(days):
            maxx = max(maxx,prices[i]-minn)
            minn = min(minn,prices[i])
        return maxx
    
    def maxProfit1(self, prices: List[int]) -> int:
        if not prices:
            return 0

        days = len(prices)
        if days == 0 or days == 1:
            return 0
        dp = [[0] * 2 for _ in range(days+1)]
        dp[0][0] = 0 #max
        dp[0][1] = float('inf') #min

        for i in range(1,days+1):
            dp[i][0] = max(dp[i-1][0],prices[i-1]-dp[i-1][1])
            dp[i][1] = min(dp[i-1][1],prices[i-1])
        return dp[-1][0]