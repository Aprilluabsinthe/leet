class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        
        for i in range(32):
            mask = 1 << i
            cnt = 0
            for j in range(len(nums)):
                if (nums[j] & mask) != 0:
                    cnt += 1
            if cnt % 3 != 0:
                # why python needs to do extra judgement here?
                if i == 31:
                    res -= mask
                else:
                    res |= mask
        
        return res