class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        res = 0;
        for i in range(len(arr)):
            t = arr[i]
            for k in range(i+1,len(arr),1):
                t ^= arr[k]
                if t == 0:
                    res += k - i
        return res