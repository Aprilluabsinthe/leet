class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero = -1
        two = len(nums)
        i = 0
        while(i < two):
            if nums[i] == 1:
                i += 1
            elif nums[i] == 0:
                zero += 1
                nums[zero],nums[i] = nums[i],nums[zero]
                i += 1
            elif nums[i] == 2:
                two -= 1
                nums[two],nums[i] = nums[i],nums[two]
