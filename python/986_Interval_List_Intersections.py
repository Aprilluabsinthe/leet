class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        res = []
        n,m = len(firstList),len(secondList)
        i,j = 0,0
        while i<n and j<m:
            left = max(firstList[i][0],secondList[j][0])
            right = min(firstList[i][1],secondList[j][1])
            if left <= right:
                res.append([left,right])
            if right == firstList[i][1]:
                i += 1
            else:
                j += 1
        return res

