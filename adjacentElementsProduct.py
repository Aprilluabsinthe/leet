def adjacentElementsProduct(inputArray):
    n = len(inputArray)
    maxx = float('-inf')
    for i in range(n-1):
        num1 = inputArray[i]
        num2 = inputArray[i+1]
        maxx = max(maxx, num1 * num2)
    return maxx
        

