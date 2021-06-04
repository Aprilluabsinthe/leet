class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i = 0 ; i < 32 ; i++){
            int oneCount = 0;
            for(int j = 0 ; j < len ; j++){
                oneCount += (nums[j] >> i) & 1;
            }
            // the contribution of one bit i
            res += oneCount * (len-oneCount);
        }
        return res;

    }
}