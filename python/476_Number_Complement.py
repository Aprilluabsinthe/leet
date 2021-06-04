class Solution:
    def findComplement(self, num: int) -> int:
        # bin()->'0b1010'
        if num != 0:
            return ((1 << (len(bin(num))-2)) - 1) ^ num
        return 1