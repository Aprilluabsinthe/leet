class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null) return result ;
        Arrays.sort(nums);
        backtrack(nums,result,new ArrayList<>(),0);
        return result;
    }
    
    public void backtrack(int[] nums,List<List<Integer>> result,List<Integer> curSet,int index) {
        if(index == nums.length){
            result.add(new ArrayList<>(curSet));
            return;
        }
        
        int i = index;
        while(i < nums.length && nums[i] == nums[index]) i++;
        backtrack(nums,result,curSet,i);
            
        curSet.add(nums[index]);
        backtrack(nums,result,curSet,index+1);
        curSet.remove(curSet.size()-1);
        
        
        
    }
}