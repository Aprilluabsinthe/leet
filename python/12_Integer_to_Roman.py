# I             1
# V             5
# X             10
# L             50
# C             100
# D             500
# M             1000

class Solution:
    def intToRoman(self, num: int) -> str:
        numMap = {'I':1,'IV':4,'V':5,'IX':9,'X':10,'XL':40,'L':50,'LC':90,'C':100,'CD':400,'D':500,'CM':900,'M':1000}
        numbers = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
        romans = ['M','CM','D','CD','C','XC','L','XL','X','IX','V','IV','I']
        res = ''
        num_left = num
        def substitute(res,num_left):
            for i in range(len(numbers)):
                if num_left < numbers[i]:continue
                elif num_left == numbers[i]:
                    return res+romans[i]
                else:
                    res += romans[i]
                    num_left -= numbers[i]
                    return substitue(res,num_left)
        
        return substitute(res,num)