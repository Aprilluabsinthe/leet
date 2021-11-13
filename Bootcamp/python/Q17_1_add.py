class Solution:
    def addBinary(self, a: str, b: str) -> str:
        x,y = int(a,2),int(b,2)
        while y:
            sum = x ^ y
            carry = (x & y) << 1
            x = sum
            y = carry
        return bin(x)[2:]
            
            