class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for(i = 0 ; i < nums.length ;i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while(j < nums.length){
            nums[j++] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        if(nums == null || n == 1){
            return;
        }

        while(slow < n && fast < n){
            while(slow < n-1 && nums[slow] != 0){
                slow += 1;
            }
            fast = slow;
            while(fast < n-1 && nums[fast] == 0){
                fast += 1;
            }
            if(slow != fast){
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }
            slow += 1;
        }
    }


}