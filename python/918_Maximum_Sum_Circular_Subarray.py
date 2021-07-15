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
        
    # Repeat
    def maxSubarraySumCircular1(self, nums: List[int]) -> int:
        n = len(nums)
        subMin = subMax = tempMin = tempMax = summ = res = nums[0]
        for i in range(1,n):
            summ += nums[i]
            
            tempMin = min(tempMin+nums[i],nums[i])
            tempMax = max(tempMax+nums[i],nums[i])
            
            subMin = min(subMin, tempMin)
            subMax = max(subMax, tempMax)
        
        if subMax < 0:
            return subMax
        
        return max(subMax, summ-subMin)
    
    # divide
    def maxSubarraySumCircular2(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0],nums[1],nums[0]+nums[1])

        # max in 1 intervals
        cur = -math.inf
        ans = -math.inf
        for i in range(n):
            cur = nums[i] + max(cur,0)
            ans = max(ans, cur)
        
        rightSum = [-math.inf] * n
        rightMax = [-math.inf] * n
        rightSum[-1] = nums[-1]
        rightMax[-1] = nums[-1]

        for i in range(n-2,-1,-1):
            rightSum[i] = rightSum[i+1] + nums[i]
            rightMax[i] = max(rightSum[i],rightMax[i+1] )

        leftSum = 0
        for i in range(n-2):
            leftSum += nums[i]
            ans = max(ans, leftSum + rightMax[i+2])
        return ans