class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
#         maxmemo = 0
#         count = 0
        
#         for i in range(1,len(nums)+1):
#             maxmemo = 0
#             for j in range(i,len(nums)+1):
#                 maxmemo = max(nums[j-1], maxmemo)
#                 if maxmemo >= left and maxmemo <= right:
#                     count += 1
#         return count
        def count(bound):
            ans = cur = 0
            for num in nums:
                cur = cur + 1 if num <= bound else 0
                ans += cur
            return ans
        
        return count(right) - count(left-1)
        
    def numSubarrayBoundedMax1(self, nums: List[int], left: int, right: int) -> int:
        j = -1
        res = 0
        temp = 0
        for i in range(len(nums)):
            if nums[i] > right:
                j = i
            if nums[i] >= left:
                temp = i - j
            res += temp
        return res
    
    def numSubarrayBoundedMax2(self, nums: List[int], left: int, right: int) -> int:
        L = 0
        result = []
        tmp = 0

        for index, num in enumerate(nums):
            if num > right:
                tmp = 0
                L = index + 1
            elif num >= left:
                tmp = index - L + 1
                result.append(tmp)
            else:
                result.append(tmp)
        print(result)
        return sum(result)

        
                