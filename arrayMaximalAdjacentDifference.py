def arrayMaximalAdjacentDifference(inputArray):
    maxGap = 0
    for i in range(1,len(inputArray)):
        maxGap = max(maxGap, abs(inputArray[i]-inputArray[i-1]))
    return maxGap
    

