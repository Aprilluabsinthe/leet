class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        n = len(candidates)
        res = []
        def dfs(index, curSum, curPath):
            if curSum > target or index == n:
                return
            if curSum == target:
                res.append(curPath[:])
                return
            dfs(index , curSum + candidates[index], curPath+[candidates[index]])
            dfs(index+1 , curSum, curPath)
        
        dfs(0,0,[])
        return res

    def combinationSum1(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        n = len(candidates)
        res = []

        def dfs(index, curSum, curPath):
            if curSum > target or index == n:
                return
            if curSum == target:
                res.append(curPath[:])
                return
            for i in range(index, n):
                if curSum + candidates[i] > target:
                    break
                curPath.append(candidates[i])
                dfs(i, curSum + candidates[i], curPath)
                curPath.pop()

        curPath = []
        dfs(0,0,curPath)
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
                if curSum + candidates[i] > target:
                    break
                helper(i, curSum + candidates[i] ,curPath+[candidates[i]])
            
        helper(0,0,[])
        return res