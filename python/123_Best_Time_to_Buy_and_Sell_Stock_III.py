class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        return self.maxProfit2(prices)
    
    def maxProfit3(self, prices: List[int]) -> int:
        buy1 = buy2 = float('-inf')
        sell1 = sell2 = 0
        for p in prices:
            buy1  = max(buy1,  -p)
            sell1 = max(sell1, buy1+p)
            buy2  = max(buy2,  sell1-p)
            sell2 = max(sell2, buy2+p)
        return sell2

    def maxProfit2(self, prices: List[int]) -> int:
        kmax = 2
        # f[i][j][k] is the maximum revenue on ith day
        # j=0: no stock, j=1: have stock
        # k: number of transactions so far
        f = [[[0]*(kmax+1) for _ in range(2)]
            for _ in range(len(prices)+1)]
        for k in range(1, kmax+1):
            f[0][1][k] = float('-inf')

        for i, p in enumerate(prices, 1):
            for k in range(1, kmax+1):
                f[i][0][k] = max(f[i-1][0][k], f[i-1][1][k]+p)
                f[i][1][k] = max(f[i-1][1][k], f[i-1][0][k-1]-p)
        return f[-1][0][-1]
    
    def maxProfit1(self, prices):
        if prices==[]:
            return 0
        length=len(prices)
        maxTransac = 2
        # [day][hold/nothold][transaction]
        dp=[ [[0] * (maxTransac+1) for _ in range(2) ] for _ in range(length) ]
        
        # day1, not hold, no pre sell, no profit
        dp[0][0][0] = 0
        # day1, hold, no pre sell, c0st
        dp[0][1][0] = -prices[0]

        # day1 can not have any sell manipulations
        dp[0][0][1] = float('-inf')
        dp[0][0][2] = float('-inf')
        dp[0][1][1]=float('-inf')
        dp[0][1][2]=float('-inf')

        for i in range(1,length):
            # day i+1, no stock, no pre sell, no profit
            dp[i][0][0]=0
            # day i+1, no stock, 1 pre sell,
            dp[i][0][1]=max(dp[i-1][1][0]+prices[i],dp[i-1][0][1])
            # day i+1, no stock, 2 pre sell,
            dp[i][0][2]=max(dp[i-1][1][1]+prices[i],dp[i-1][0][2])
            # day i+1, have stock, 0 pre sell, buy
            dp[i][1][0]=max(dp[i-1][0][0]-prices[i],dp[i-1][1][0])
            # day i+1, have stock, 1 pre sell
            dp[i][1][1]=max(dp[i-1][0][1]-prices[i],dp[i-1][1][1])
            # day i+1, have stock, 2 pre sell, not allow
            dp[i][1][2]=float('-inf')
        
        return max(dp[length-1][0][1],dp[length-1][0][2],0)