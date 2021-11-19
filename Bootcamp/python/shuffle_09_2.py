# Majority Element: 
# A majority element is an element that makes up more than half of the items in
# an array.
# Given a positive integers array, find the majority element. 
# If there is no majority element,
# return -1. 
# Do this in O(N) time and 0(1) space.
# Input: 1 2 5 9 5 9 5 5 5
# Output: 5

# array [] 
# count up tp half of items : 8 5
# return : the majority number
# no majority: return -1 

# if always a majority

import collections


def majority(array):
    array = sorted(array) # nlogn
    return array[len(array)//2]

def majority(array):
    n = len(array)
    map = collections.defaultdict(int) # 
    for num in array:
        map[num] += 1
        if map[num] > n // 2:
            return num 
    return -1


# [1 2 5 9 5 9 5 5 5]
# [1 2 3 9 5 9 5 5 5]
#  1 0 1 0 1 0 1 2 3

#  5 len//2+1 count+1
# other < len//2+1 count-1
# len(majority) > len(other)

# count 

def majorityVoting(array):
    majority = 0
    count = 0

    for num in array: # 
        if count == 0: # 
            majority = num # 1
        if num == majority:
            count += 1
        else:
            count -= 1 # count = 0
    return majority

array = [1,2,3,4,5,5,5,5,5,5]
print(majorityVoting(array))
    
