class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        for(int num : nums){
            if( i < 2 || num > nums[i-2]){
                nums[i++] = num;
            }
        
        }
        return i;
    }

    public int removeDuplicates1(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int index = 2;

        for(int i = 2 ; i < nums.length ; i++){
            if(nums[i] != nums[index-2]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    // by 0901
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(nums.length <= 2) return nums.length;
        int index = 2;
        for(int i = 2 ; i < n ; i++){
            if(nums[i] != nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}