# O(N)
import unittest

def canPermutePalindrome(s: str) -> bool:
    if not s:
        return False
    s = s.lower()
    checker = 0
    for c in s:
        if c==' ':continue
        checker ^= (1<<(ord(c)-ord('a')))
    count = 0
    while checker!=0:
        checker = checker & (checker-1)
        count += 1
    return count <= 1


def pal_perm(phrase):
    '''function checks if a string is a permutation of a palindrome or not'''
    table = [0 for _ in range(ord('z') - ord('a') + 1)]
    countodd = 0
    for c in phrase:
        x = char_number(c)
        if x != -1:
            table[x] += 1
            if table[x] % 2:
                countodd += 1
            else:
                countodd -= 1

    return countodd <= 1

def char_number(c):
    a = ord('a')
    z = ord('z')
    A = ord('A')
    Z = ord('Z')
    val = ord(c)

    if a <= val <= z:
        return val - a
    elif A <= val <= Z:
        return val - A
    return -1


class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ('Tact Coa', True),
        ('jhsabckuj ahjsbckj', True),
        ('Able was I ere I saw Elba', True),
        ('So patient a nurse to nurse a patient so', False),
        ('Random Words', False),
        ('Not a Palindrome', False),
        ('no x in nixon', True),
        ('azAZ', True)]

    def test_pal_perm(self):
        for [test_string, expected] in self.data:
            actual = pal_perm(test_string)
            self.assertEqual(actual, expected)
    
    def test_canPermutePalindrome(self):
        for [test_string, expected] in self.data:
            actual = canPermutePalindrome(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()