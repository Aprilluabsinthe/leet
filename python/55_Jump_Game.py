class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1 or n == 0:
            return True
        
        cur = nums[0]
        i = 0
        while cur!=0 and i < n:
            cur -= 1
            cur = max(cur,nums[i])
            i += 1
        return i == n
