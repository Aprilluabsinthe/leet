class Solution {

    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        dfs(candidates , target , 0, 0 , new ArrayList<Integer>());
        return ans;

    }

    public void dfs(int[] candidates, int target, int index,int curSum, List<Integer> curPath){
        if(curSum == target){
            ans.add(new ArrayList<Integer>(curPath));
            return;
        }
        if(curSum > target){
            return;
        }
        
        for(int i = index; i < candidates.length ; i++){
            curPath.add(candidates[i]);
            dfs(candidates , target , i, curSum + candidates[i] , curPath);
            curPath.remove(curPath.size()-1);
        }    

    }
}