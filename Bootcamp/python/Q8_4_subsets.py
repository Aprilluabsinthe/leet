class Solution:
    def backtrack(self,nums, index, res, cur):
        if index == len(nums):
            res.append(cur[:])
            return

        # for i in range(index,len(nums)):
        self.backtrack(nums,index+1,res,cur)

        cur.append(nums[index])
        self.backtrack(nums,index+1,res,cur)
        cur.pop()
            
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        res = []
        cur = []
        self.backtrack(nums, 0, res,cur)
        return res


