def findMissing(array):
    def findMissing(array,column):
        if column < 0:
            return 0
        bitIs0 = []
        bitIs1 = []

        for num in array:
            if fetch(num, column) == 0:
                bitIs0.append(num)
            else:
                bitIs1.append(num)
        
        if len(bitIs0) <= len(bitIs1):
            missing = findMissing(bitIs0,column-1)
            return (missing << 1) | 0
        else:
            missing = findMissing(bitIs1,column-1)
            return (missing << 1) | 1
