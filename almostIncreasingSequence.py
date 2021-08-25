def almostIncreasingSequence(sequence):
    n = len(sequence)
    gaps = [0] * (n-1)
    chance = 1
    for i in range(1,n):
        gaps[i-1] = sequence[i]-sequence[i-1]
        if gaps[i-1] <= 0:
            if chance == 0:
                return False
            chance -= 1
            # smaller than previous
            toComparePrev = float('-inf')
            toCompareNext = float('inf')
            if i >= 2:
                toComparePrev = sequence[i-2]
            if i <= n-2:
                toCompareNext = sequence[i+1]
            # compare with the one previous to the previous
            if sequence[i] - toComparePrev <= 0 and toCompareNext - sequence[i-1] <= 0:
                return False
    return True
            
                

