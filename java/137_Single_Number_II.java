class Solution {
    public int singleNumber(int[] nums) {
        return singleNumber2(nums);
    }

    public int singleNumber1(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < 32 ; i++){
            int mask = 1<< i;
            int cnt = 0;
            for(int j = 0 ; j < nums.length; j++){
                if((nums[j] & mask) != 0){
                    cnt++;
                }
            }
            if (cnt % 3 != 0){
                res |= mask;
            }
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for ( int num : nums){
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }
        return b;
    }
}