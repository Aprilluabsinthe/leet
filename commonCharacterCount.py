def commonCharacterCount(s1, s2):
    import collections
    dicts1 = collections.defaultdict(int)
    for i in range(len(s1)):
        dicts1[s1[i]] += 1
    
    count = 0
    for j in range(len(s2)):
        if dicts1[s2[j]] != 0:
           dicts1[s2[j]] -= 1
           count += 1
    return count 