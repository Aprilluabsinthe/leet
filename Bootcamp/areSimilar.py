def areSimilar(a, b):
    if len(a) != len(b) or sum(a) != sum(b):
        return False
    
    idx = []
    
    for i in range(len(a)):
        if a[i] != b[i]:
            idx.append(i)
    
    if len(idx) == 0:
        return True
    elif len(idx) == 2:
        return a[idx[0]] == b[idx[1]] and a[idx[1]] == b[idx[0]]
    else:
        return False

def areSimilar1(a,b):
    return sorted(A)==sorted(B) and sum([a!=b for a,b in zip(A,B)])<=2

