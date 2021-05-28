class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] G = new int[n+1];
        int[] N = new int[n+1];

        G[1] = nums[0];
        for(int i = 2 ; i <= n ; i++){
            if(i != n){
                G[i] = Math.max(G[i-1],G[i-2]+nums[i-1]);
            }else{
                G[i] = Math.max(G[i-1],G[i-2]);
            }
        }

        for(int i = 2 ; i <= n ; i++){
            N[i] = Math.max(N[i-1],N[i-2]+nums[i-1]);
        }

        return Math.max(G[n],N[n]);
    }
}