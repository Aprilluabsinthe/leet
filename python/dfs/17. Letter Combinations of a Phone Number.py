# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
# A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
# # https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phoneMap = {
            '2':['a','b','c'],
            '3':['d','e','f'],
            '4':['g','h','i'],
            '5':['j','k','l'],
            '6':['m','n','o'],
            '7':['p','q','r','s'],
            '8':['t','u','v'],
            '9':['w','x','y','z'],
        }
        if len(digits)==0 or not digits:
            return []

        res = []

        def backtrack(combination, nextdigits):
            if len(combination)==len(digits):
                res.append(combination)
            else:
                for letter in phoneMap[nextdigits[0]]:
                    backtrack(combination + letter, nextdigits[1:])
        
        backtrack("",digits)
        return res