class Solution {
    public int divide(int dividend, int divisor) {
        if( dividend == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int result = 0 ;
        for(int i = 31 ; i >= 0 ; i--){
            if((t>>i) >= d){
                result += 1<<i;
                t -= d<<i;
            }
        }
        return negative ? -result : result;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int dividend = Integer.parseInt(line);
            line = in.readLine();
            int divisor = Integer.parseInt(line);
            
            int ret = new Solution().divide(dividend, divisor);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}