class Solution:
    def minCostII(self, costs: List[List[int]]) -> int:
        return self.minCostII_3(costs)

    def find2min(self,cost):
        costList = list(enumerate(cost))
        sortedList = sorted(costList, key=lambda x: x[1])
        return sortedList[0],sortedList[1]
    
    def minCostII_1(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        houseLen = len(costs)
        if houseLen == 0:
            return 0
        if houseLen == 1:
            return min(costs[0])
        
        colorLen = len(costs[0])
        dp = [[float('inf')] * colorLen for _ in range(houseLen)]

        dp[0] = costs[0]
        min1,min2 = self.find2min(dp[0])

        for house in range(1,houseLen):
            for color in range(colorLen):
                if color!= min1[0]:
                    dp[house][color] = min1[1] + costs[house][color]
                else:
                    dp[house][color] = min2[1] + costs[house][color]
            min1,min2 = self.find2min(dp[house])

        return min( dp[houseLen-1])
    

    def minCostII_2(self,costs):
        house, color = len(costs), len(costs[0])
        if color == 1 : return min([c[0] for c in costs])
        if house == 1 : return min(costs[0])

        f = [[float('inf')] * color for _ in range(house+1)]
        f[0] = [0] * color
        for i in range(1, house+1):
            for k in range(color):
                f[i][k] = min([f[i-1][l] for l in range(color) if l!=k])
                f[i][k] += costs[i-1][k]
        return min(f[-1])
    
    def minCostII_3(self,costs):
        if not costs: 
            return 0
        house,color=len(costs),len(costs[0])
        if color == 1:
            return min(c[0] for c in costs)
        dp=[[float('inf')] * color for _ in range(house)]
        dp[0]=costs[0]

        sortList = sorted(list(costs[0]))
        minCost = sortList[0]
        secondMinCost = sortList[1]
        min_color=dp[0].index( minCost )

        for i in range(1,house):
            for j in range(color):
                if j!=min_color:
                    dp[i][j]=costs[i][j]+minCost
                else:
                    dp[i][j]=costs[i][j]+secondMinCost
            sortList = sorted(list(dp[i]))
            minCost = sortList[0]
            secondMinCost = sortList[1]
            min_color=dp[i].index( minCost )
        return min(dp[house-1])
