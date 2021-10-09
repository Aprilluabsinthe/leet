class Solution {
    int R = 0;
    int C = 0;
    int result = 0;
    Map<String,Integer> memo = new HashMap<>(); 
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        
        this.R = obstacleGrid.length;
        this.C = obstacleGrid[0].length;
        String res = (R-1) + "_" + (C-1);
        dfs2(obstacleGrid,0,0);
        return memo.get(res);
    }
    
    public int dfs(int[][] obstacleGrid, int x, int y) {
        if(x >= R || x < 0 || y>=C || y < 0 || obstacleGrid[x][y] == 1){
            return 0;
        }
        
        if(x == R-1 && y == C-1){
            return 1;
        }
        
        String key = x + "_" + y;
        if(this.memo.containsKey(key)){
            return memo.get(key);
        }
        
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        int newX = 0;
        int newY = 0;
        int res = 0;
        
        for(int i = 0 ; i < 2 ; i++){
            newX = x + dx[i];
            newY = y + dy[i];
            res += dfs(obstacleGrid,newX,newY);
        }
        memo.put(key,res);
        
        return memo.get(key);
    }
    
    public boolean positionValid(int[][] obstacleGrid, int x, int y) {
        return (x < this.R && x >= 0 && y < this.C && y >= 0 && obstacleGrid[x][y] != 1 && obstacleGrid[x][y] != -1);  
    }
    
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        
        int[][] memo = new int[R+1][C+1];
        
        for(int row  = 1 ; row < R+1 ; row++){
            for(int col = 1 ; col < C+1 ; col++){
                if(row == 1 && col == 1 && obstacleGrid[row-1][col-1]!=1){
                    memo[1][1] = 1;
                    continue;
                }
                if(obstacleGrid[row-1][col-1]!=1){
                    memo[row][col] = memo[row-1][col] + memo[row][col-1];
                }else{
                    memo[row][col] = 0;
                }
            }
        }
        return memo[R][C];
    }
}