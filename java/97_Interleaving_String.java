class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1len = s1.length();
        int s2len = s2.length();
        int s3len = s3.length();

        if (s1len + s2len != s3len) return false;

        boolean[][] dp = new boolean[s1len + 1][s2len + 1];

        dp[0][0] = true;
        for (int i = 1; i <= s1len && (dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1) ); i++) dp[i][0] = true;
        for (int i = 1; i <= s2len && (dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1)); i++) dp[0][i] = true;

        for (int i = 1; i <= s1.length(); i++) { //s1
            for (int j = 1; j <= s2.length(); j++) { //s2

                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1))
                        || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j -1));
            }

        }

        return dp[s1len][s2len];

    }
}