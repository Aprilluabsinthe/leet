class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length;
        while(left<right){
            int mid = left + (right - left) / 2;
            int maxx = Math.max(arr[mid],Math.max(arr[mid-1],arr[mid+1]));
            if(maxx == arr[mid]) return mid;
            else if (maxx == arr[mid-1]) right = mid;
            else if (maxx == arr[mid+1]) left = mid+1;
        }
        return left;

    }
}