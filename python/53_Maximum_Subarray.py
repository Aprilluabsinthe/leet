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

    # repeat
    # O(N),O(N)
    def maxSubArray2(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        res = nums[0]
        for i in range(1,n,1):
            dp[i] = max(dp[i-1]+nums[i], nums[i])
            res = max(res, dp[i])
        return res
    
    # O(N),O(1)
    def maxSubArray3(self, nums: List[int]) -> int:
        n = len(nums)
        cursum = nums[0]
        res = nums[0]
        for i in range(1,n,1):
            cursum = max(cursum+nums[i], nums[i])
            res = max(res, cursum)
        return res

    def divideAndConquer(self, nums: List[int]) -> int:
        def findMax(nums, left, right):
            # base case:
            if left > right:
                return -math.inf
            
            mid = left + (right-left)//2
            curr = left_best = right_best = 0

            for i in range(mid-1, left-1, -1):
                curr += nums[i]
                left_best = max(left_best, curr)
            
            curr = 0
            for i in range(mid+1, right+1, 1):
                curr += nums[i]
                right_best = max(right_best, curr)

            best_all = nums[mid] + left_best + right_best
            
            # recursive
            left_half = findMax(nums, left, mid-1)
            right_half = findMax(nums, mid+1, right)

            return max(best_all, left_half,right_half)
        
        return findMax(nums, 0, len(nums)-1)