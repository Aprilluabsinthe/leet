class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int index = 0;
        int cursor = 0;
        int resLen = n;
        while(index < n && cursor < n){
            if(nums[cursor] != val){
                if(index != cursor){
                    nums[index] = nums[cursor];
                }
                index += 1;         
            }else{
                resLen -= 1;
            }
            cursor += 1;   
        }
        return resLen;
    } 
}