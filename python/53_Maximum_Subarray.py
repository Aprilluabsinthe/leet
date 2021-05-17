class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        ans = nums[0]
        for num in nums:
            sum = max(num,sum+num)
            ans = max(ans,sum)
        return ans