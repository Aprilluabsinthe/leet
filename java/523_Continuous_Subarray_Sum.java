class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        List<Integer> preSum = new ArrayList<>();
        preSum.add(nums[0]%k);
        Set hashSet = new HashSet<>();

        for(int i = 1; i < n ; i++){
            preSum.add(i,(preSum.get(i-1) + nums[i])%k);
            if (preSum.get(i) % k == 0 || hashSet.contains(preSum.get(i))){
                return true;
            }
            hashSet.add(preSum.get(i-1));
        }
        return false;
    }

    public boolean checkSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 1 ; i <= n; i++){
            sum[i] = (sum[i-1] + nums[i-1])%k;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 2 ; i <= n ; i++){
            set.add(sum[i-2]);
            if(set.contains(sum[i])){
                return true;
            }
        }
        return false;
    }
}