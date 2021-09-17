class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length-1;
        while(left <= right){
            while(left < right && nums[left] == nums[left+1]) left++;
            while(left < right && nums[right] == nums[right-1]) right--;
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}public class Q81_Search_in_Rotated_Sorted_Array_II {
    
}
