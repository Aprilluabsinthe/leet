class Solution {
    public int[] singleNumber(int[] nums) {
        return singleNumber2(nums);
    }

    public int[] singleNumber1(int[] nums) {
        int xorAns = 0;
        for(int num : nums){
            xorAns ^= num;
        }

        // find the bit which is 1
        int bitMask = 1;
        while( (xorAns & 1) == 0 ){
            xorAns >>= 1;
            bitMask <<= 1;
        }

        int num1 = 0, num2 = 0;
        for(int num : nums){
            if( (num & bitMask) == 0){
                num1 ^= num;
            }
            else{
                num2 ^= num;
            }
        }
        return new int[]{num1,num2};
    }

    public int[] singleNumber2(int[] nums) {
        int xorAns = 0;
        for(int num : nums){
            xorAns ^= num;
        }

        // find the last set bit
        xorAns &= -xorAns; 

        int[] res = new int[2];
        for(int num : nums){
            if((num & xorAns) == 0){
                res[0] ^= num;
            }
            else{
                res[1] ^= num;
            }
        }
        return res;
    }
}