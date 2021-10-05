class Solution:
    ans = []
    s = ''
    letterMap = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }

    def letterCombinations(self, digits: str) -> List[str]:
        self.ans.clear()
        if digits == '':return[]
        self.backtracking(digits,0)
        return self.ans

    def backtracking(self, digits: str, index:int):
        if index == len(digits):
            self.ans.append(self.s)
            return
        
        for choice in self.letterMap[digits[index]]:
            self.s += choice
            self.backtracking(digits,index+1)
            self.s = self.s[:-1]