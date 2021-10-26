#!/bin/python3
import os
import sys

import collections

def hasCircle(fromVetex,node,visited,record):
    visited.add(node)
    
    record.add(node)
    for neib in fromVetex[node]:
        if(neib not in visited):
            if hasCircle(fromVetex,neib,visited,record):
                return True
        elif neib in record:
            return True
    record.remove(node)
    
    return False


def isDAG(edges):
    print(edges)
    errorCode = set()
    
    if not edges:
        errorCode.add(-5)
    
    fromVetex = collections.defaultdict(set)
    toVetex = collections.defaultdict(set)
    for edge in edges:
        if not edge[0].isalpha() or not edge[1].isalpha():
            errorCode.add(-5)
            
        if edge[1] not in fromVetex[edge[0]]:
            fromVetex[edge[0]].add(edge[1])
        else:
            # duplicate arcs
            errorCode.add(-4)
        if edge[0] not in toVetex[edge[1]]:
            toVetex[edge[1]].add(edge[0])
        else:
            # duplicate arcs
            errorCode.add(-4)
    
    print("errorCode",errorCode)
    setFrom = set(fromVetex.keys())
    setTo = set(toVetex.keys())
    
    start = setFrom.difference(setTo)
    end = setTo.difference(setFrom)
    allnode = setFrom.union(setTo)
    
    # no start vertices
    if(len(start) < 1):
        errorCode.add(-1)
        return max(errorCode)
    
    # multiple start vertices
    if(len(start) > 1):
        errorCode.add(-2)
        return max(errorCode)
    
    # len start == 1
    isTree = True
    for toV in setTo:
        isTree = isTree and (len(toVetex[toV]) <= 1)
    if isTree:
        return 0 if len(errorCode) == 0 else max(errorCode)
    
        
    # detect circle
    visited = set()
    record = set()
    
    hascircle = hasCircle(fromVetex,list(start)[0],visited,record)
    
    if(hascircle):
        errorCode.add(-3)
    else:
        return 1 if len(errorCode) == 0 else max(errorCode)
    
    return max(errorCode) if errorCode else -5

    
    
    
    
if __name__ == '__main__':
    with open(os.environ['OUTPUT_PATH'], 'w') as fptr:
        edges_count = int(input().strip())
        e = [input().strip() for _ in range(edges_count)]
        edges = [(s[0],s[1]) for s in e]
        fptr.write(str(isDAG(edges)) + '\n')
