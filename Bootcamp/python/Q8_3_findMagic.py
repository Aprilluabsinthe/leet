def findMagicIndex(arr,left,right):
    if (arr is None or left > right):
        return -1
    
    while(left <= right):
        mid = left + (right - left )//2
        if(mid == arr[mid]):
            return mid
        elif mid > arr[mid]:
            return findMagicIndex(arr,mid+1,right)
        else:
            return findMagicIndex(arr,mid,mid-1)