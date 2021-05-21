class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        ans = nums[0]
        for num in nums:
            sum = max(num,sum+num)
            ans = max(ans,sum)
        return ans
    
    def maxSubArray1(self, nums: List[int]) -> int:
        sum = 0
        res = nums[0]
        dp = [nums[0]]  * len(nums)
        for i,num in enumerate(nums):
            if i == 0:
                continue
            dp[i] = max( dp[i-1]+num , num )
            res = max( res, dp[i] )

        return res