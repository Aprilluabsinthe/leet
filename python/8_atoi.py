class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if not s or len(s) == 0:
            return 0
        sign = 1
        curNum = s
        maxInt = 2 ** 31 -1
        minInt = -2 ** 31
        # if the first is a symbol
        if s[0] in ['-','+']:
            sign = -1 if s[0] == '-' else 1
            curNum = s[1:]
        
        i = 0
        while i < len(curNum):
            if curNum[i].isdigit():
                i += 1
            else:
                break
            
        curNum = curNum[:i]
        
        # now is the leading numbers
        ans = 0
        for j in range(len(curNum)):
            if ans < maxInt//10:
                ans = ans * 10 + ord(curNum[j]) - ord('0')
            elif ans == maxInt//10:
                if (sign == 1 and ord(curNum[j]) - ord('0') > 7) or (sign == -1 and ord(curNum[j]) - ord('0') > 8):
                    return maxInt if sign == 1 else minInt
                else:
                    ans = ans * 10 + ord(curNum[j]) - ord('0') 
            else:
                return maxInt if sign == 1 else minInt
        return ans * sign
    
    def myAtoi2(self, s: str) -> int:
        s=s.lstrip()
        str1=""
        sign=""
        if len(s)>0 and s[0] in ["+","-"]:
            sign=s[0]
            s=s[1:]
        for i in range(len(s)):
            if s[i].isdigit():
                str1=str1+s[i]
            else:
                 break
        if str1.isdigit():
            num=int(sign+str1)
            if num>2**31-1:
                num=2**31-1
            if num<-2**31:
                num=-2**31
            return num
        else:
            return 0