class Solution {
    public void wiggleSort(int[] nums) {
        boolean valley = false;
        for(int i = 0 ; i < nums.length-1; i++){
            if(valley){
                if(nums[i] > nums[i+1]) swap(nums,i,i+1);
            }else{
                if(nums[i] < nums[i+1]) swap(nums,i,i+1);
            }
            valley = !valley;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}