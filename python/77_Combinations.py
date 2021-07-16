class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        path = []

        def backtrack(index):
            if len(path) == k:
                res.append(path[:])
                return
            
            for i in range( index , n+1 ):
                path.append(i)
                backtrack(i+1)
                path.pop()
        
        backtrack( 1 )
        return res
