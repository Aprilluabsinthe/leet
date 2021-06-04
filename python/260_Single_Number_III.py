class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        xorAns = 0
        for num in nums:
            xorAns ^= num
        
        bit = 1
        while (xorAns & 1) == 0:
            xorAns >>= 1
            bit <<= 1
        num1 = 0
        num2 = 0
        
        for num in nums:
            if (num & bit) == 0:
                num1 ^= num
            else:
                num2 ^= num
        return [num1, num2]