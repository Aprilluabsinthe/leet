class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0:
            return False
        left = ('{','(','[')
        right = ('}',')',']')
        pair = {'}':'{' , ')':'(' , ']':'['}
        stack = []
        for b in s:
            if b in left:
                stack.append(b)
            if b in right:
                if not stack:
                    return False
                if stack and stack[-1] != pair[b]:
                    return False
                else:
                    stack.pop()
        return len(stack) == 0
                
            
        
        