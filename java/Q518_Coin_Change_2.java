public class Q518_Coin_Change_2 {
    public int change1(int amount, int[] coins) {
        int dp[][] = new int[amount+1][coins.length];
        return changehelpser(amount,coins,0,dp);
        
    }
    
    public int changehelpser(int total, int[] coins, int index, int[][] dp){
        if(dp[total][index] > 0) return dp[total][index];
        
        int coin = coins[index];
        
        if(index == coins.length-1){
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        
        int countWays = 0;
        for(int amount = 0 ; amount <= total ; amount += coin){
            countWays += changehelpser(total-amount,coins,index+1,dp);
        }
        
        dp[total][index] = countWays;
        
        return countWays;
    }

    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        
        dp[0] = 1;
        
        for(int coin : coins){
            for(int x = coin ; x < amount + 1 ; x++){
                dp[x] += dp[x-coin];
            }
        }
        
        return dp[amount];
    }
}
