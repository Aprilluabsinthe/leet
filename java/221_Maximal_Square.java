class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 0 || row == 0){
            return 0;
        }
        int[][] dp = new int[row+1][col+1];
        int maxSide = 0;

        for(int i = 1 ; i < row +1 ; i++){
            for(int j = 1; j < col + 1; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1] , dp[i-1][j]));
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;

    }
}