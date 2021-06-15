class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left,right = 0,len(arr)-1 # left close, right open
        while left < right:
            mid = left + (right - left) // 2
            if arr[mid-1] < arr[mid] and arr[mid] > arr[mid+1]:
                return mid
            elif arr[mid-1] < arr[mid] and arr[mid] < arr[mid+1]:
                left = mid + 1
            elif arr[mid-1] > arr[mid] and arr[mid] > arr[mid+1]:
                right = mid
        return left

