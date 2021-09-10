class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        farest = 0
        end = 0 # current boundry
        step = 0
        for i in range(n-1):
            farest = max( farest , nums[i]+i )
            if i == end:
                step += 1
                end = farest
        return step
