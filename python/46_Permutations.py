class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        n = len(nums)
        if n == 1:
            return [[nums[0]]]
        res = []
        combination = []
        
        def backtracking( res , combination , nums):
            if len( combination ) == len(nums):
                res.append(combination[:])
                return res
            
            for num in nums:
                if num not in combination:
                    combination.append(num)
                    backtracking(res, combination, nums)
                    combination.pop()
        
        def backtracking1( nums , combination ):
            if not nums:
                res.append( combination )
                return
            
            for i in range(len(nums)):
                backtracking1( nums[:i]+nums[i+1:] , combination + [nums[i]] )

        # backtracking(res, combination, nums)
        backtracking1(nums, [] )
        return res

