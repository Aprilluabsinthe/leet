class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k == 0 or k == 1:
            return 0
        left = 0
        prod = 1
        res = 0
        for right in range(len(nums)):
            prod *= nums[right]
            while prod >= k:
                prod /= nums[left]
                left += 1
            res += right - left + 1
        return res