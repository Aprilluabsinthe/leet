class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        n = len(nums)
        if n < 3:
            return []
        if n == 3:
            return [nums] if sum(nums) == 0 else []
        
        nums.sort()

        res = []
        for firstIndex in range(n):
            if nums[firstIndex] > 0:
                break
            if firstIndex > 0 and nums[firstIndex] == nums[firstIndex-1]:
                continue
            
            secondIndex = firstIndex + 1
            thirdIndex = n - 1
            
            while(secondIndex < thirdIndex):
                summ = nums[firstIndex] + nums[secondIndex] + nums[thirdIndex]
                if summ == 0:
                    res.append([nums[firstIndex], nums[secondIndex] , nums[thirdIndex]])
                    while secondIndex < secondIndex and nums[secondIndex] == nums[secondIndex+1]:
                        secondIndex += 1
                    while secondIndex < thirdIndex and nums[thirdIndex] == nums[thirdIndex-1]:
                        thirdIndex -= 1
                    secondIndex += 1
                    thirdIndex -= 1
                        
                elif summ > 0:
                    thirdIndex -= 1
                elif summ < 0:
                    secondIndex += 1
        return res

            
            
        