class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        
        def findInRow(nums,target):
            left = 0
            right = col-1
            while left <= right:
                mid = left + (right - left) //2
                if nums[mid] == target:
                    return True
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return False

        for j in range(row):
            if matrix[j][0] <= target <= matrix[j][-1]:
                return findInRow(matrix[j],target)
        
        return False