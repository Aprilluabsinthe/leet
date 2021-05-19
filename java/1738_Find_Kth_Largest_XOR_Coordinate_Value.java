import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m+1][n+1];
        List<Integer> results = new ArrayList<Integer>();
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                pre[i][j] = matrix[i-1][j-1] ^ pre[i-1][j] ^ pre[i][j-1] ^ pre[i-1][j-1];
                results.add(pre[i][j]);
            }
        }
        Collections.sort(results,
        new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        });
        return results.get(k-1);
    }
}