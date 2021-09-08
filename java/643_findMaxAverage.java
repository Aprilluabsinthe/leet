class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int windowSum = 0;

        for(int i = 0 ; i < k ; i++){
            windowSum += nums[i];
        }

        double maxx = (double) windowSum / k;

        for(int j = k; j < n ; j++){
            windowSum = windowSum - nums[j-k] + nums[j];
            maxx = Math.max(maxx, (double) windowSum / k);
        }
        return maxx;
    }
}