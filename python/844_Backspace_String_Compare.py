class Solution:
    def backspaceCompare1(self, s: str, t: str) -> bool:
        if len(s) == 0 and len(t) == 0:
            return True
    
        def finalString(string):
            res = []
            for i in range(len(string)):
                if string[i]!='#':
                    res.append(string[i])
                else:
                    if res:
                        res.pop()
            return res

        res_s = finalString(s)
        res_t = finalString(t)

        return res_s == res_t

    def backspaceCompare(self, s: str, t: str) -> bool:
        if not s and not t:
            return True
        if len(s) ==0 and len(t) == 0:
            return True
        
        jumpS = jumpT = 0
        
        i = len(s)-1
        j = len(t)-1
        while i >= 0 or j >= 0:
            while i >= 0:
                if s[i] == '#':
                    jumpS += 1
                    i -= 1
                else:
                    if jumpS > 0:
                        jumpS -= 1
                        i -= 1
                    else:
                        break
            
            while j >= 0:
                if t[j] == '#':
                    jumpT += 1
                    j -= 1
                else:
                    if jumpT > 0:
                        jumpT -= 1
                        j -= 1
                    else:
                        break
            
            if i >= 0 and j >= 0:
                if s[i] != t[j]:
                    return False
            elif i >= 0 or j >= 0:
                return False
            
            i -= 1
            j -= 1
        
        return True