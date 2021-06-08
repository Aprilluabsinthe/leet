class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        val = [0 for _ in range(max(nums)+1)]
        for n in nums:
            val[n] += n
        
        def rob(nums):
            pre, cur = 0,0
            for num in nums:
                pre,cur = cur,max(cur,pre+num)
            return cur
        
        return rob(val)
