class Solution:
    def isUnique(self, astr: str) -> bool:
        mark = 0
        for char in astr:
            move_bits = ord(char) - ord('a')
            if(mark & (1 << move_bits) != 0):
                return False
            else:
                mark |= (1 << move_bits)
        return True