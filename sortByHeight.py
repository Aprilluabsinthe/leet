def sortByHeight(a):
    n = len(a)
    temp = [0] * n
    valids = []
    treeIndex = []
    
    for i in range(n):
        if a[i] == -1:
            treeIndex.append(i)
        else:
            valids.append(a[i])
    
    valids.sort()
    
    res = []
    for i in range(n):
        if i in treeIndex:
            res.append(-1)
        else:
            res.append(valids.pop(0))
    return res
