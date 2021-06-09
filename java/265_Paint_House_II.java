class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int n = costs[0].length;
        int min = 0, secondMin = 0, color = -1;
        for(int[] cost : costs){
            int preColor = color;
            int preMin = min;
            int preSecondMin = secondMin;
            min = Integer.MAX_VALUE;
            secondMin = Integer.MAX_VALUE;
            for(int i = 0 ; i < n ; i++){
                int curMin = (i == preColor)?preSecondMin:preMin;
                int price = curMin + cost[i];

                if(price < secondMin){
                    if(price < min){
                        secondMin = min;
                        min = price;
                        color = i;
                    }
                    else{
                        secondMin = price;
                    }         
                }
            }
        }
        return min;
    }
}