import unittest
def compress(chars) -> int:
    res = l = r = 0
    
    while l < len(chars):
        while r < len(chars) and chars[l] == chars[r]:
            r += 1
        temp = chars[l] + str(r-l) if r-l>1 else chars[l] 
        for c in temp:
            chars[res] = c
            res += 1
        l = r
    return chars[:res]

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        (list('aabcccccaaa'), list('a2bc5a3')),
        (list('abcdef'), list('abcdef'))
    ]

    def test_string_compression(self):
        for [test_string, expected] in self.data:
            actual = compress(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()