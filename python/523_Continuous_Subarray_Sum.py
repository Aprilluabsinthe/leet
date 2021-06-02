class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        if n == 0 or k == 0:
            return False
        hashSet = set()
        preSum = [nums[0]%k] + [0] * (n-1)
        for i in range(1,n):
            preSum[i] = ( preSum[i-1] + nums[i] ) % k
            if preSum[i] == 0 or preSum[i] in hashSet:
                return True
            hashSet.add(preSum[i-1])
        return False