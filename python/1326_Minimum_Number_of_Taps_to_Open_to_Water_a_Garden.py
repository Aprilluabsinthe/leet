class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        farest = [0] * n
        for i in range( n + 1):
            for j in range( max(0,i-ranges[i]) , min(n,i+ranges[i]) ):
                farest[j] = max(farest[j], min(n,i+ranges[i]))


        ans = 0
        end = last = 0
        for i in range(n):
            if farest[i] == 0:
                return -1
            last = max( last , farest[i] )
            if i == end:
                end = last
                ans += 1
        return ans
