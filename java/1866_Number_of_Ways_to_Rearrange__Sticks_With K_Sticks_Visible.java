class Solution {
    public int rearrangeSticks(int n, int k) {
        return rearrangeSticks_sliding(n,k);
    }

    public int rearrangeSticks_normal(int n, int k) {
        int mod = 1000000007;
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1;
        
        for(int i = 1 ; i < n+1 ; i++){
            for (int j = 1; j <= Math.min(k,i); j++){
                dp[i][j] = dp[i-1][j-1];
                if (i - 1 >= j) {
                    dp[i][j] += (i-1) * dp[i-1][j];
                    dp[i][j] %= mod;
                }
            }
        }
        return (int)dp[n][k];
    }

    public int rearrangeSticks_sliding(int n, int k) {
        int mod = 1000000007;
        long[] dp = new long[k+1];
        dp[0] = 1;
        
        for(int i = 1 ; i < n+1 ; i++){
            long[] sliding = new long[k+1];
            for (int j = 1; j < k+1; j++){
                sliding[j] = (dp[j-1] + (i-1) * dp[j]) % mod;
            }
            dp = sliding;
        }
        return (int)dp[k];
    }
}

// class Solution {
//     public int rearrangeSticks(int n, int k) {
//         long[][] dp = new long[n + 1][k + 1];
//         dp[0][0] = 1;
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= k; j++) {
//                 dp[i][j] = (dp[i - 1][j - 1] + ((i - 1) * dp[i - 1][j]) % 1000000007) % 1000000007;
//             }
//         }
//         return (int)dp[n][k];
//     }
// }