def isLucky(n):
    numArr = []
    while n:
        numArr.append(n%10)
        n = n // 10
    digitsLen = len(numArr)
    
    sumTemp = 0
    for i in range(digitsLen):
        if i < digitsLen//2:
            sumTemp += numArr[i]
        else:
            sumTemp -= numArr[i]
    return sumTemp == 0
        
        
