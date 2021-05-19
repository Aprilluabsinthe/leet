class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int t = arr[i];
            for(int k = i + 1; k < arr.length; k++){
                t ^= arr[k];
                if(t == 0){
                    res += k - i;
                }
            }
        }
        return res;
    }
}
