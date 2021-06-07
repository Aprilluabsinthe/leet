class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        allSum = sum(num for num in nums)
        if allSum < target:
            return 0
        
        if (allSum - target)%2 != 0:
            return 0

        subtract = (allSum - target)//2

        n = len(nums)
        dp = [0] * (subtract+1)
        dp[0] = 1
        for num in nums:
            for i in range(subtract,num-1,-1):
                dp[i] += dp[i-num]
        return dp[subtract]
            
