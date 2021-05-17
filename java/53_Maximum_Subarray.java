public class 53_Maximum_Subarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int ans =nums[0];
            int sum = 0;
            for(int num : nums){
                sum = Math.max(sum + num,num);
                ans = Math.max(ans,sum);
            }
            return ans;
        }
    }
}
