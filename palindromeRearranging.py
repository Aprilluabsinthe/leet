def palindromeRearranging(inputString):
    n = len(inputString)
    # even, can not have single elements
    # odd, can and must have one single elements
    
    from collections import Counter
    count = Counter(inputString)
    
    numOdd = 0
    if n % 2 == 1:
        numOdd = 1
        
    for c in count:
        if count[c] % 2 == 1:
            numOdd -= 1
    
    return numOdd == 0

    # return sum([inputString.count(i)%2 for i in set(inputString)]) <= 1