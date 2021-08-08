class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import defaultdict
        if not s or not t:
            return ""
        seen = set()
        dict_t = Counter(t)
        required = len(dict_t)
        left = 0
        right = 0
        window_counts = defaultdict(int)
        formed = 0
        curLen = float('inf')
        ans = float('inf')
        res = ""

        while right < len(s):
            window_counts[s[right]] += 1
            if s[right] in dict_t and window_counts[s[right]] == dict_t[s[right]]:
                formed += 1
            while left <= right and formed == required:
                curLen = right - left + 1
                if curLen < ans:
                    ans = curLen
                    res = s[left : right+1]
                window_counts[s[left]] -= 1
                if s[left] in dict_t and window_counts[s[left]] < dict_t[s[left]]:
                    formed -= 1
                left += 1
            right += 1
        return res
              
        
    def minWindow1(self, s: str, t: str) -> str:
        from collections import defaultdict
        dict_t = Counter(t)
        required = len(dict_t)
        
        l , r = 0, 0
        formed = 0
        window_counts = defaultdict(int)
        
        ans = float('inf'), None, None
        
        while r < len(s):
            char = s[r]
            window_counts[char] += 1
            if char in dict_t and window_counts[char] == dict_t[char]:
                formed += 1
            while l <= r and formed == required:
                char = s[l]
                if r - l + 1 < ans[0]:
                    ans = (r-l+1, l, r)
                window_counts[char] -= 1
                if char in dict_t and window_counts[char] < dict_t[char]:
                    formed -= 1
                l += 1
            r += 1
            
        return "" if ans[0] == float('inf') else s[ans[1] : ans[2] + 1]
                
        