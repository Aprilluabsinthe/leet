class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        n = len(palindrome)
        if n == 1:
            return ""

        def isPalindrom(palindrome:str) -> bool:
            i,j = 0,len(palindrome)-1
            while i <= j:
                if palindrome[i] == palindrome[j]:
                    i += 1
                    j -= 1
                else:
                    return False
            return True
        
        res = ""
        for i in range(n//2 + 1):
            if palindrome[i] != 'a':
                res = palindrome[:i] + 'a' + palindrome[i+1:]
                if not isPalindrom(res):
                    break
            if i == n//2:
                res = palindrome[:-1] + 'b'
                break
        if isPalindrom(res):
            return ""
        return res

# method 2
    def breakPalindrome1(self, palindrome: str) -> str:
        n = len(palindrome)
        if n <= 1:
            return ""
        palindrome = list(palindrome)

        for i in range(n//2):
            if palindrome[i] != 'a':
                palindrome[i] = 'a'
                return ''.join(palindrome)
        palindrome[-1] = 'b'
        return ''.join(palindrome)
