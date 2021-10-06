class Solution:
    def missingNumber(self, arr: List[int]) -> int:
        gap = (arr[-1] - arr[0]) // len(arr)
        lo = 0
        hi = len(arr)-1
        
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if(arr[mid] == arr[0] + mid * gap):
                lo = mid+1
            else:
                hi = mid-1
        
        return arr[0] + lo * gap
    
    def missingNumber1(self, arr: List[int]) -> int:
        gap = (arr[-1] - arr[0]) // len(arr)
        for i in range(1, len(arr)):
            if arr[i]-arr[i-1] != gap:
                return arr[i-1] + gap
        return arr[0]