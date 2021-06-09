import java.util.*;

class Solution {
    public int minCost(int[][] costs) {
        int colorLen = 3;
        int houseLen = costs.length;
        if(houseLen == 0) return 0;
        int[][] dp = new int[houseLen][3];
        dp[0] = costs[0];

        for(int i = 1; i < houseLen ; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }

        return Math.min( Math.min( dp[houseLen-1][0],dp[houseLen-1][1]),dp[houseLen-1][2]);
        // return Collections.min(Arrays.asList(dp[houseLen-1]));
    }


}