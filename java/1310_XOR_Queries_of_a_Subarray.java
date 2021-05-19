class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int narr = arr.length;
        int nqueries = queries.length;
        int[] sum = new int[narr + 1];

        for (int i = 1 ; i <= narr ; i++){
            sum[i] = sum[i-1] ^ arr[i-1];
        }

        int[] ans = new int[nqueries];
        for(int i=0; i < nqueries ; i++){
            ans[i] = sum[queries[i][0]] ^ sum[queries[i][1]+1];
        }
        return ans;
    }
}