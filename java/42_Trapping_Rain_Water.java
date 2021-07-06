class Solution {
    public int trap(int[] height) {
        // return dp(height);
        // return compressedPointers(height);
        return monoStack(height);
    }

    public int monoStack(int[] height) {
        if(height == null){
            return 0;
        }
        if(height.length<=1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int i = 0 ; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curIdx = stack.pop();
                while(!stack.isEmpty() && height[stack.peek()] == height[curIdx]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop] , height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }

    public int dp(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = height[0];
        dp[n-1][1]= height[n-1];
        for(int i = 1; i < n ; i++){
            dp[i][0] = Math.max(dp[i-1][0], height[i]);
        }
        for(int i = n-2; i >= 0 ; i--){
            dp[i][1] = Math.max(dp[i+1][1], height[i]);
        }

        int res = 0;
        for(int i = 1 ; i < n-1; i++){
            res += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return res;
    }

    public int compressedPointers(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;
        int lmax = 0, rmax = 0;
        while(left <= right){
            if(lmax <= rmax){
                lmax = Math.max(lmax, height[left]);
                res += lmax - height[left];
                left++;
            }
            else{
                rmax = Math.max(rmax, height[right]);
                res += rmax - height[right];
                right--;
            }
        }
        return res;
    }
    
}