# Sorted Merge: 
# You are given two sorted arrays, A and B, where A has a large enough buffer at the
# end to hold B. Write a method to merge B into A in sorted order.

# A[],m k
# B[],n
# m = k+n
# return A

# A[.....,0,0,0]
#             | 
# compare A, and B

# B has no spaces
def sortedMerge(A,k,B):
    # total length = len(A)
    # A : k valid numebrs
    # B : leb(B) valid numbers
    # A , B sorted

    # three pointers
    lenA = len(A)
    lenB = len(B)

    pA, pB = k-1, lenB-1
    pCur = lenA-1

    while pA >= 0 and pB >= 0: # A and B
        if(A[pA] <=  B[pB]): # B[pb] is bigger
            A[pCur] = B[pB]
            pCur -= 1
            pB -= 1
        else: # A[pa] is bigger
            A[pCur] = A[pA]
            pCur -= 1
            pA -= 1

    # pA < 0  or pB < 0
    # pB[1] 0
    while pB >= 0: # B not finished, insert into A[0...] 
        A[pCur] = B[pB]
        pCur -= 1
        pB -= 1
    
    return A


A = [1,2,3,7,0,0,0]
B = [4,6,7]
print(sortedMerge(A,4,B))

