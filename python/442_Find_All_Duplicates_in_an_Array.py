class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        temp = 0
        res = []
        for num in nums:
            if (temp & (1 << num)) > 0:
                res.append(num)
            else:
                temp |= (1 << num)
        return res