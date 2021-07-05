class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums == null){
            return ans;
        }
        if(nums.length == 1){
            if(nums[0]!=target){
                return ans;
            }
            else{
                return new int[]{0,0};
            }
        }

        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return findrange(nums,mid);
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] findrange(int[] nums, int mid){
        int left = mid, right = mid;
        while(left >= 0 && nums[left] == nums[mid]){
            left -= 1;
        }
        while(right < nums.length && nums[right] == nums[mid]){
            right += 1;
        }
        return new int[]{left+1,right-1};
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        res[0] = binarySearch(nums,target, true);
        res[1] = binarySearch(nums,target, false);
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean leftOrRight){
        int res = -1;
        int left = 0, right = nums.length -1, mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            }
            else if (target > nums[mid]){
                left = mid + 1;
            }
            else{
                res = mid;
                if(leftOrRight) right = mid -1;
                else left = mid + 1;
            }
        }
        return res;
    }
}
