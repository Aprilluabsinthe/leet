class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        frontSet = [0] * (k+1)
        rearSet = [0] * (k+1)

        for i in range(k):
            frontSet[i+1] = frontSet[i] + cardPoints[i]
            rearSet[i+1] = rearSet[i] + cardPoints[n-i-1]
        
        maxScore = 0
        for i in range(k+1):
            ans = frontSet[i] + rearSet[k-i]
            maxScore = max(maxScore,ans)
        return maxScore