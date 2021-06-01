class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        n = len(nums)
        # no circle
        dpmax = [0] * n
        dpmax[0] = nums[0]
        dpmin = [0] * n
        dpmin[0] = nums[0]
        maxx = nums[0]
        minn = nums[0]
        summ = nums[0]
        for i in range(1,n):
            summ += nums[i]
            dpmax[i] = max( dpmax[i-1] + nums[i] , nums[i])
            dpmin[i] = min( dpmin[i-1] + nums[i] , nums[i])
            maxx = max(maxx,dpmax[i])
            minn = min(minn,dpmin[i])
        # all negetive
        if maxx < 0:
            return maxx
        maxx = max(summ-minn,maxx)
        return maxx
        
        # 