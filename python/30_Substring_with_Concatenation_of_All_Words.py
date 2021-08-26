def findSubstring(self, s: str, words: List[str]) -> List[int]:
    if not s or not words:
        return []
    
    from collections import Counter
    n = len(words)
    wordLen = len(words[0])
    allLen = wordLen * n
    sLen = len(s)
    
    wordsCounter = Counter(words)
    res = []
    
    for i in range(0,sLen-allLen+1):
        tempString = s[i:i+allLen]
        tempCount = []
        # break words
        for j in range(0,allLen,wordLen):
            tempCount.append(tempString[j:j+wordLen])
        if Counter(tempCount) == wordsCounter:
            res.append(i)
    return res
            
        