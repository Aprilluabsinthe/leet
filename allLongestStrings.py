def allLongestStrings(inputArray):
    import collections
    lenDict = collections.defaultdict(list)
    maxLen = 0
    for i in range(len(inputArray)):
        word = inputArray[i]
        lenWord = len(word)
        maxLen = max(maxLen, lenWord)
        lenDict[lenWord].append(word)
    return lenDict[maxLen]