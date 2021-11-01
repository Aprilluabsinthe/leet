class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        lens = len(s)
        lent = len(t)
        if (s == t) or abs(lens-lent) > 1:
            return False
        
        if lens-lent == 1:
            return self.addAndDelete(t,s)
        elif lent-lens == 1:
            return self.addAndDelete(s,t)
        else:
            return self.replace(s,t)
        
    def addAndDelete(self, shorter: str, longer: str) -> bool:
        if len(shorter) == 0:
            return True
        i,j = 0,0
        diff = 0
        while i < len(shorter) and j < len(longer):
            if shorter[i] == longer[j]:
                i += 1
                j += 1
            else:
                j += 1
                diff += 1
        return i == len(shorter) and diff <= 1
            
    
    def replace(self, shorter: str, longer: str) -> bool:
        i,j = 0,0
        diff = 0
        while i < len(shorter) and j < len(longer):
            if shorter[i] != longer[j]:
                diff += 1
            i += 1
            j += 1
        return i == len(shorter) and j==len(longer) and diff == 1
        