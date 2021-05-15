class Solution:
    def romanToInt(self, s: str) -> int:
        romanMap = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        if len(s) == 0 or not s:
            return 0
        ans = 0
        for i in range(len(s)):
            right = romanMap[s[i+1]] if i < len(s)-1 else 0
            if romanMap[s[i]] >= right:
                ans += romanMap[s[i]]
            else:
                ans -= romanMap[s[i]]
        return ans