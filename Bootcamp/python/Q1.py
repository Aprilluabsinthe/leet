
# one edit
# 3 action: add, delete, replace
# return bool 
# input: two strings

# aabb -> 4
# abb ->3
# different: 1 add/delete
# aabb -> 4
# abbb ->4
# same: replace -> 

def OneEdit(s,t):
    lens = len(s)
    lent = len(t)
    # assume lens is smaller/or equal
    # delete
    if lens > lent:
        return OneEdit(t,s)
    
    if lens + 1 != lent:
        return False
    
    # s add one char , and become t
    # s replace one char, become t
    for i in range(lens):
        if s[i] != t[i]: # diff!
            if lens == lent: # replace
                # aabb -> 4
                # abbb ->4
                print(s[i+1:])
                print(t[i+1:])
                return s[i+1:] == t[i+1:]
            else: # add
                # abb ->3
                # aabb -> 4
                return s[i:] == t[i+1:]
    return lens+1==lent
            
        
a = "aabb"
b = "abbb"

print(OneEdit(a, b))
