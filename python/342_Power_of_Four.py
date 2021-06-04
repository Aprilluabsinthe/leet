class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        for i in range(0,32,2):
            mask = (1 << i)
            if (n ^ mask) == 0:
                return True
        return False