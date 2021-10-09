class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null) return result ;
        
        // for(int k = 0 ; k < nums.length+1 ;k++){
        //     dfs(nums,result,new ArrayList<>(),0,k);
        // }
        backtrack(nums,result,new ArrayList<>(),0);
        return result;
        
    }
    
    public void dfs(int[] nums,List<List<Integer>> result,List<Integer> curSet,int index,int len_k) {
        if(curSet.size() == len_k){
            result.add(new ArrayList<>(curSet));
            return;
        }
        
        for(int i = index ; i < nums.length ; i++){
            curSet.add(nums[i]);
            dfs(nums,result,curSet,i+1,len_k);
            curSet.remove(curSet.size()-1);
        }
        
    }
    
    public void backtrack(int[] nums,List<List<Integer>> result,List<Integer> curSet,int index) {
        if(index == nums.length){
            result.add(new ArrayList<>(curSet));
            return ;
        }
        
        backtrack(nums,result,curSet,index+1);
        
        curSet.add(nums[index]);
        backtrack(nums,result,curSet,index+1);
        curSet.remove(curSet.size()-1);
    }
}

// class Solution {
//   List<List<Integer>> output = new ArrayList();
//   int n, k;

//   public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
//     // if the combination is done
//     if (curr.size() == k) {
//       output.add(new ArrayList(curr));
//       return;
//     }
//     for (int i = first; i < n; ++i) {
//       // add i into the current combination
//       curr.add(nums[i]);
//       // use next integers to complete the combination
//       backtrack(i + 1, curr, nums);
//       // backtrack
//       curr.remove(curr.size() - 1);
//     }
//   }

//   public List<List<Integer>> subsets(int[] nums) {
//     n = nums.length;
//     for (k = 0; k < n + 1; ++k) {
//       backtrack(0, new ArrayList<Integer>(), nums);
//     }
//     return output;
//   }
// }