class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0],nums[1])
        
        dp = [0] + [nums[0]] + [max(nums[0],nums[1])] + [0] * (n-2)
        for i in range(3,n+1):
            dp[i] = max(dp[i-2] + nums[i-1],dp[i-1])
        
        return dp[-1]