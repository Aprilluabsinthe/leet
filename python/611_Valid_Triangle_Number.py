class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        # if length is smaller than 3, can not form a triangle
        if len(nums) < 3:
            return 0
        
        nums.sort()
        res = 0

        for i in range(len(nums)-1, 1, -1):
            left, right = 0, i-1
            while left < right:
                if nums[left] + nums[right] > nums[i]:
                    # i, right and any num on the right of left
                    res += right-left
                    right -= 1
                else:
                    left += 1
        return res


