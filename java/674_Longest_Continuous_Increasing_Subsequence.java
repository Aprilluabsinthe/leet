class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int left = 0;
        int max = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > nums[i-1]){
                max = Math.max(i-left+1, max);
            }else{
                left = i;
            }
        }
        return max;
    }


    public int findLengthOfLCIS1(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        int res = 0;
        if(n == 1){
            return 1;
        }

        while( i < n-1 ){
            j = i+1;
            int tempLength = 1;
            while (j < n){
                if( nums[j] > nums[i]){
                    tempLength += 1;
                    j += 1;
                    i += 1;
                }
                else{
                    break;
                }
            }
            res = Math.max(res, tempLength);
            i = j;
        }
        return res;
    }
}