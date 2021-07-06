class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) <= 1:
            return 0
        
        max_height = 0
        max_height_index = 0

        for i in range(len(height)):
            h = height[i]
            if h > max_height:
                max_height = h
                max_height_index = i
        
        area = 0

        temp = height[0]
        for i in range(max_height_index):
            if height[i] > temp:
                temp = height[i]
            else:
                area += (temp - height[i])
        
        temp = height[-1]
        for i in range( len(height)-1, max_height_index ,-1):
            if height[i] > temp:
                temp = height[i]
            else:
                area += (temp - height[i])
        
        return area