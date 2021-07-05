class Solution:
    def backtrack(self, candidates: List[int], target: int, index:int, curPath:List[int], res: List[List[int]] ):
        if(target == 0):
            res.append(curPath[:])
            return
        if(target < 0 or index == len(candidates)):
            return
        
        for i in range(index, len(candidates)):
            if target-candidates[i] < 0:
                break
            
            curPath.append(candidates[i])
            self.backtrack(candidates,target-candidates[i],i,curPath,res)
            curPath.pop()

    def combinationSum1(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        self.backtrack(candidates,target,0,[],res)
        return res

        def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        n = len(candidates)
        res = []
        def helper(index, curSum, curPath):
            if curSum > target or index == n:
                return
            if curSum == target:
                res.append(curPath[:])
                return
            for i in range(index, n):
                if curSum + candidates[index] > target:
                    break
                helper(index, curSum + candidates[index] ,curPath+[candidates[index]])
            
        helper(0,0,[])
        return res
