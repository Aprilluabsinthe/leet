class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        i,j = 0,n-1
        area = 0
        while i < j:
            high = min(height[i],height[j])
            wide = j - i
            area = max(area,high*wide)
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return area