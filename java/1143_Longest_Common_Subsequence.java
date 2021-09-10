class Solution {
    private int[][] memo;
    private String text1;
    private String text2;
    
    public int longestCommonSubsequence(String text1, String text2) {
        this.memo = new int[text1.length()+1][text2.length()+1];
        for(int i = 0 ; i < text1.length() ; i++){
            for(int j = 0 ; j < text2.length() ; j++){
                this.memo[i][j] = -1;
            }
        }
        this.text1 = text1;
        this.text2 = text2;
        return memoSolve1(0,0);
    }
    
    private int memoSolve0(int p1, int p2){
        if(memo[p1][p2] != -1){
            return memo[p1][p2];
        }
        
        int option1 = memoSolve0( p1+1, p2 );
        
        int firstOccur = text2.indexOf(text1.charAt(p1) , p2);
        int option2 = 0;
        if(firstOccur != -1){
            option2 = 1 + memoSolve0( p1+1, firstOccur+1 );
        }
        memo[p1][p2] = Math.max(option1,option2);
        return memo[p1][p2];
    }
    
    private int memoSolve1(int p1, int p2){
        if(memo[p1][p2] != -1){
            return memo[p1][p2];
        }
        
        int answer = 0;
        if(text1.charAt(p1) == text2.charAt(p2)){
            answer = 1 + memoSolve1(p1+1, p2+1);
        }else{
            answer = Math.max(memoSolve1(p1+1, p2) , memoSolve1(p1, p2+1));
        }
        memo[p1][p2] = answer;
        return answer;
        
    }
    
}