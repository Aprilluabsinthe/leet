def makeArrayConsecutive2(statues):
    minNum = min(statues)
    maxNum = max(statues)
    
    return maxNum-minNum-len(statues)+1

