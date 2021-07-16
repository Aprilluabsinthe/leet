enum Index{
    GOOD, BAD, UNKNOWN
}

class Solution {
    Index[] memo;
    
    public boolean canJumpFromPosition(int position, int[] nums) {
        if(memo[position] != Index.UNKNOWN){
            return memo[position] == Index.GOOD ? true : false;
        }
        
        int furthestJump = Math.min( position + nums[position] , nums.length-1 );
        
        for( int next = position + 1; next <= furthestJump ; next++ ){
            if( canJumpFromPosition( next , nums ) ){
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
    
    public boolean canJump_topdown(int[] nums) {
        memo = new Index[nums.length];
        for(int i = 0 ; i < memo.length ; i++){
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition( 0 , nums );
    }

    public boolean canJump_bottomup(int[] nums){
        Index[] memo = new Index[nums.length];
        for (int i = 0 ; i < memo.length ;i++){
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length-1] = Index.GOOD;
        
        for(int i = nums.length-2 ; i >= 0 ; i--){
            int furthestJump = Math.min( i+nums[i],nums.length-1 );
            for(int j = i+1 ; j <= furthestJump ; j++){
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }
    
}