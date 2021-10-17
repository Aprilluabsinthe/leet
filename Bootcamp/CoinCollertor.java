import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static int[] collector(boolean[][] grid, int C) {
        if(grid == null) return new int[0];
        if(grid.length == 0) return new int[0];
        if(grid[0].length == 0) return new int[0];

        int row = grid.length;
        int col = grid[0].length;
        
        int[][] memo = new int[3][col+2];

        memo[1][1] = (grid[0][0] == true) ? (C+1):C;
        
        for(int j = 2 ; j  < col+1 ; j++){
            memo[1][j] = (grid[0][j-1] == true) ? 1:-1;
            memo[1][j] += memo[1][j-1];
        }
          
        int r = 2;
        while( r < row+1){
            for(int j = 1 ; j  < col+1 ; j++){
                memo[0][j] = (grid[r-1][j-1] == true) ? 1:-1;
                memo[2][j] = Math.max(memo[0][j]+memo[1][j],memo[0][j] + memo[2][j-1]);
            }
            for(int j = col ; j  >= 1 ; j--){
                memo[0][j] = Math.max(memo[0][j]+memo[1][j],memo[0][j] + memo[0][j+1]);
                memo[2][j] = Math.max(memo[0][j],memo[2][j]);
                memo[1][j] = memo[2][j];
            }
            r++;
        }

        int[] res = new int[col];
        for(int i = 0 ; i < col ; i++){
            res[i] = memo[1][i+1];
        }
        
        return res;
    }
    
    public static int[] collector1(boolean[][] grid, int C) {
        if(grid == null) return new int[0];
        if(grid.length == 0) return new int[0];
        if(grid[0].length == 0) return new int[0];

        int row = grid.length;
        int col = grid[0].length;
        
        
        int[][] dp = new int[row+1][col+2];
        int[][] memo = new int[3][col+2];

        
        dp[1][1] = (grid[0][0] == true) ? (C+1):C;
        
        for(int i = 1 ; i  < row+1 ; i++){
            for(int j = 1 ; j  < col+1 ; j++){
                if(i == 1 && j == 1) continue;
                dp[i][j] = (grid[i-1][j-1] == true) ? 1:-1;
            }
        }
        
        for(int j = 1 ; j  < col+1 ; j++){
            dp[1][j] += dp[1][j-1];
        }
        
        for(int i = 2 ; i  < row+1 ; i++){
            for(int j = 1 ; j  < col+1 ; j++){
                dp[0][j] = dp[i][j];
                dp[i][j] = Math.max(dp[0][j]+dp[i-1][j],dp[0][j] + dp[i][j-1]);
            }
            
            for(int j = col ; j  >= 1 ; j--){
                dp[0][j] = Math.max(dp[0][j]+dp[i-1][j],dp[0][j] + dp[0][j+1]);
                dp[i][j] = Math.max(dp[0][j],dp[i][j]);
            }
        }
        
        
        int[] res = new int[col];
        for(int i = 0 ; i < col ; i++){
            res[i] = dp[row][i+1];
        }
        
        return res;
    }

    // see http://www.jstatsoft.org/v08/i14/paper for definition of xorshift RNG
    static int seed = 123456;
    static int xorshift() {
       seed ^= (seed << 1);
       seed ^= (seed >> 3);
       seed ^= (seed << 10);
       return seed;
    }

   private static boolean[][] read_grid(int rows, int cols, BufferedReader in) throws IOException {
      boolean[][] grid = new boolean[rows][cols];
      if (cols < 100 && rows < 100) {
         for (int i=0; i < rows; i++) {
            String line = in.readLine().trim();
            for (int j=0; j < cols; j++) {
               grid[i][j] = line.charAt(j) == '*';
            }
         }
      } else {
         seed = Integer.parseInt(in.readLine().trim());
         for (int i=0; i < rows; i++) {
            for (int j=0; j < rows; j++) {
               grid[i][j] = ((xorshift()&0x100) != 0);
            }
         }
      }
      return grid;
   }

   private static void run(boolean[][] grid, int C) throws IOException {
      final String fileName = System.getenv("OUTPUT_PATH");
      BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
      int[] res = null;
      PrintStream err = System.err;
      System.setErr(System.out);
      try {
         res = collector(grid,C);
      } catch (Exception e) {
          printException(err,e);
      }
      if (res == null) {
         bw.write("NULL\n");
      } else if (res.length > 1000) {
         bw.write(String.valueOf(res[0]));
         String plus = String.valueOf("+");
         String minus = String.valueOf("-");
         for (int i=1; i < res.length; i++) {
            if (res[i] == res[i-1]+1) bw.write(plus);
            else if (res[i] == res[i-1]-1) bw.write(minus);
            else {
               bw.newLine();
               bw.write(String.valueOf(res[i]));
            }
            if (i % 100 == 0) bw.newLine();
         }
         bw.newLine();
      } else {
         for(int i=0; i < res.length; i++) {
            bw.write(String.valueOf(res[i]));
            bw.newLine();
         }
      }
      bw.write("DONE");
      bw.newLine();        
      bw.close();
      return;
   }
   
   public static void main(String[] args) throws IOException{
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int C = Integer.parseInt(in.readLine().trim());
      int gridRows = Integer.parseInt(in.readLine().trim());
      int gridCols = Integer.parseInt(in.readLine().trim());
      run(read_grid(gridRows,gridCols,in),C) ;
   }

    private static void printException(PrintStream err, Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        for (int i = 0; i < trace.length; ++i) {
            if (trace[i].getClassName().equals("Solution")) {
                err.println(e.getClass().getName()+" at line "+trace[i].getLineNumber());
                System.exit(1);
            }
        }
        err.println(e.getClass().getName());
        System.exit(1);
    }
}
