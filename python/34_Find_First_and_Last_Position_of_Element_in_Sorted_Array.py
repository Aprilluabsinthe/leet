class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        L = 0
        R = len(nums) - 1
        while L <= R:
            mid = L + (R-L)//2
            if nums[mid] == target:
                start = mid 
                end = mid
                while start >= 0 and nums[start] == target: 
                    start -= 1
                while end < len(nums) and nums[end] == target: 
                    end += 1
                return [start+1, end-1]
            elif nums[mid] < target: 
                L = mid + 1
            else: 
                R = mid - 1
        return [-1, -1]