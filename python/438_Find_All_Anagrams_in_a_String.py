class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n,m = len(s),len(p)
        res = []
        
        if n < m:
            return res
        
        p_cnt = [0] * 26
        s_cnt = [0] * 26
        
        for i in range(m):
            p_cnt[ord(p[i])-ord('a')] += 1
            s_cnt[ord(s[i])-ord('a')] += 1
        if s_cnt == p_cnt:
            res.append(0)
        
        for i in range(m,n):
            s_cnt[ord(s[i-m])-ord('a')] -= 1
            s_cnt[ord(s[i])-ord('a')] += 1
            
            if s_cnt == p_cnt:
                res.append(i-m+1)
        return res
    
    def findAnagrams_pointers(self, s: str, p: str) -> List[int]:
        n,m = len(s),len(p)
        res = []
        p_cnt = [0] * 26
        s_cnt = [0] * 26
        
        for i in range(m):
            p_cnt[ord(p[i])-ord('a')] += 1
        
        left = 0
        for right in range(n):
            cur_right = ord(s[right])-ord('a')
            s_cnt[cur_right] += 1
            while s_cnt[cur_right] > p_cnt[cur_right]:
                cur_left = ord(s[left])-ord('a')
                s_cnt[cur_left] -= 1
                left += 1
            if right - left + 1 == m:
                res.append(left)
        return res
                
                
        
        