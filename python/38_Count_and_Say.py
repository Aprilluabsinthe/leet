class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        result = ""

        lastRes = self.countAndSay(n-1)
        length = len(lastRes)

        i,j = 0,0
        while j < length:
            if lastRes[i] == lastRes[j]:
                j += 1
            else:
                result += str(j-i)
                result += lastRes[i]
                i = j
        
        result += str(j-i)
        result += lastRes[i]

        return result
            
        