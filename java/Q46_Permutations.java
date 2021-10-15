class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,result,new ArrayList<>());
        return result;
    }
    
    public void backtrack(int[] nums,int index,List<List<Integer>> result,List<Integer> curCombination) {
        if(index == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums){
                perm.add(num);
            }
            result.add(perm);
            return;
        }
        
        for(int i = index ; i < nums.length; i++){
            swap(nums, index, i);
            // curCombination.add(nums[i]);
            backtrack(nums,index+1,result,curCombination);
            // curCombination.remove(curCombination.size()-1);
            swap(nums, index, i);
        }
        
    }
    
    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         Permutation(nums,nums.length);
//         return finalList;
//     }
    
//     public List<List<Integer>> finalList =  new ArrayList<>();
    
//     public void Permutation(int[] nums, int size){
//         if(size==1){
//             List<Integer> s = new ArrayList<>();
//             for(int i=0;i<nums.length;i++){
//                 s.add(nums[i]);
//             }
//             finalList.add(s);
//             return;
//         }
//             for(int i=0;i<size;i++){
//                 swap(nums,i,size-1);
//                 Permutation(nums,size-1);
//                 swap(nums,i,size-1);
//             }
        
//     }
    
//     public void swap(int[] nums, int index1, int index2){
//         int temp = nums[index1];
//         nums[index1] = nums[index2];
//         nums[index2] = temp;
//     }
// }