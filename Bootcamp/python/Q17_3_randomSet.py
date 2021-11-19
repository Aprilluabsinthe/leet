import random
class randomSet:
    def pickrecursively(set,m,i):
        if( i + 1 < m):
            return
        elif(i + 1 == m):
            res = set[0:m].copy()
            return res
        else:
            res = self.pickrecursively(set,m,i-1)
            k = random.randint(0,i)
            if k < m:
                res[k] = set[i]
            return res
    
    def pickIteratively(original, m):
        if m > original.length:
            return
        
        res = [0 for _ in range(m)]
        for i in range(m):
            res[i] = original[i]
        
        for i in range(m,original.length):
            k = random.randint(0,i)
            if k < m:
                res[k] = original[i]
        return res
    
    if __name__ == '__main__':
        print(self.pickrecursively([1,2,3,4,8,5,6,7],3,8))