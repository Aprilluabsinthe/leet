class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null) return 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = (num > max) ? num : max;
        }

        int[] sumNums = new int[ max + 1];
        
        for(int num : nums){
            sumNums[num] += num;
        }
        
        int pre = 0 , cur = 0;
        for(int sum : sumNums){
            int temp = pre;
            pre = cur;
            cur = Math.max( temp+sum, cur );
            // pre = cur;
        }
        
        return cur;

    }
}