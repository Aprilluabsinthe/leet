class Solution {
    public void sortColors(int[] nums) {
        // [], inclusive
        int zero = -1;
        int two = nums.length;
        int i = 0;
        while(i < two){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2){
                two--;
                swap(nums,i,two);
            }
            else{
                zero++;
                swap(nums,zero,i);
                i++;
            }
        }
    }

    public void swap(int[] nums ,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors2(int[] nums) {
        int count0 = 0,count1 = 0,count2 = 0;
        int len = nums.length;
        for(int i = 0; i < len ;i++){
            assert (nums[i] >= 0 && nums[i] <= 2);
            if (nums[i] == 0){
                nums[count2++] = 2;
                nums[count1++] = 1;
                nums[count0++] = 0;
            }
            else if(nums[i] == 1){
                nums[count2++] = 2;
                nums[count1++] = 1;
            }
            else {
                nums[count2++] = 2;
            }
        }
    }


    public void sortColors1(int[] nums) {
        int len = nums.length;
        int count0 = 0,count1 = 0,count2 = 0;
        for (int num : nums){
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }
        for(int i = 0 ; i < len ;i++){
            if(i < count0){
                nums[i] = 0;
            }
            if( i>= count0 && i < count0 + count1){
                nums[i] = 1;
            }
            if( i>= count0 + count1){
                nums[i] = 2;
            }
        }
    }


}