def arrayChange(inputArray):
    n = len(inputArray)
    res = 0
    for i in range(1,n):
        gap = inputArray[i] - inputArray[i-1]
        if gap <= 0:
            inputArray[i] += 1 - gap
            res += 1 - gap
    return res
        

