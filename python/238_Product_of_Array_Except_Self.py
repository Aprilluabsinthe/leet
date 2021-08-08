class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        total = 1
        countzero = 0
        totalnozero = 1
        for i in range(len(nums)):
            total *= nums[i]
            if nums[i] == 0:
                countzero += 1
                continue
            totalnozero *= nums[i]
            
        res = [0] * len(nums)
        
        for i in range(len(nums)):
            if nums[i] != 0:
                res[i] = total // nums[i]
            else:
                if countzero > 1:
                    res[i] = 0
                else:
                    res[i] = totalnozero
        return res
                    
            
            
        