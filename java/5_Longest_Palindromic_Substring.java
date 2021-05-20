class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for(int l = 0 ; l < n ; l++){
            for(int index = 0 ; index + l < n ; index++){
                int j = index + l;
                if(l == 0){
                    dp[index][j] = true;
                }
                else if(l == 1){
                    dp[index][j] = (s.charAt(index) == s.charAt(j));
                }
                else{
                    dp[index][j] = (s.charAt(index) == s.charAt(j)) && dp[index+1][j-1];
                }
                if(dp[index][j] && l + 1 > ans.length()){
                    ans = s.substring(index,j+1);
                }
            }
        }
        return ans;
    }
}
