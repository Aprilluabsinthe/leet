class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        
        int a = 0;
        int b = 1;
        int c = 1;
        
        for(int i = 0 ; i < n ; i++){
            int temp = c;
            c = a+b+temp;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    public int tribonacci1(int n) {
        if(n == 0) return 0;
        
        int[] memo = new int[38];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        
        for(int i = 3 ; i < n+1 ; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        
        return memo[n];
    }
}