class Solution:
    def subsets2(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        
        for i in range(len(nums)):
            for subs in res[:]:
                res.append(subs + [nums[i]])
        
        return res
    
    def subsets(self, nums: List[int]) -> List[List[int]]: 
        res = []
        combination = []
        def backtrack(index):
            res.append(combination[:])
            if index >= len(nums):
                return
            
            for i in range(index, len(nums)):
                combination.append(nums[i])
                backtrack(i+1)
                combination.pop()
        
        backtrack(0)
        return res
            
        