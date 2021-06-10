class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        own = -prices[0]
        notOwn = 0
        for price in prices:
            notOwn,own= max(own+price,notOwn),max(own,notOwn-price)
        return notOwn


    # 压缩空间之前
    def maxProfit1(self, prices):
        days = len(prices)
        dp = [[0] * 2 for _ in range(days+1)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]

        for i in range(1,days+1):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i-1])
            dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i-1])
        return max(dp[-1][0],dp[-1][1])