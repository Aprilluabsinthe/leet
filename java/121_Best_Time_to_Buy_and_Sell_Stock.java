class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit1(prices);
    }

    public int maxProfit1(int[] prices) {
        int days = prices.length;
        if(days <= 1){
            return 0;
        }
        int[][] dp = new int[days+1][2];
        dp[0][0] = 0; // maxx
        dp[0][1] = prices[0]; // minn
        for(int i = 1 ; i < days + 1 ; i++){
            dp[i][0] = Math.max(dp[i-1][0] , prices[i-1] - dp[i-1][1]);
            dp[i][1] = Math.min(dp[i-1][1] , prices[i-1]);
        }
        return dp[days][0];

    }

    public int maxProfit2(int[] prices) {
        int maxx = 0;
        int minn = prices[0];
        for( int price : prices){
            maxx = Math.max(maxx,price-minn);
            minn = Math.min(minn,price);
        }
        return maxx;
    }

}