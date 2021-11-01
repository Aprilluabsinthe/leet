import unittest

def rotateString1(s: str, goal: str) -> bool:
    if len(s) != len(goal):
        return False
    s = s * 2
    try:
        return s.index(goal) != -1
    except:
        return False
    
def rotateString( s: str, goal: str) -> bool:
    for x in range(len(s)):
        s = s[len(s)-1] + s[0:len(s)-1]
        if s == goal:
            return True
    return False

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        (('abcde', 'cdeab'),True),
        (('abcde', 'abced'),False)
    ]

    def test_string_compression1(self):
        for [testString, expected] in self.data:
            s,goal = testString
            actual = rotateString1(s,goal)
            self.assertEqual(actual, expected)

    def test_string_compression(self):
        for [testString, expected] in self.data:
            s,goal = testString
            actual = rotateString(s,goal)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()