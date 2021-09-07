import java.util.Random;
class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n-k;
        int left = 0;
        int right = n-1;
        quickSort(nums,left,right,target);
        return nums[target];
    }
    
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public void randomInd(int[] nums, int left, int right){
        int randomIdx = new Random().nextInt(right-left+1) + left;
        swap(nums,left, randomIdx);
    }
    
    public void quickSort(int[] nums, int left, int right, int target){
        if(left>=right){
            return;
        }
        
        randomInd(nums,left,right);
        
        int ll = left;
        int rr = right;
        int pivot = nums[left];
        
        while(ll < rr){
            while(ll<rr && nums[rr]>= pivot) rr--;
            while(ll<rr && nums[ll]<= pivot) ll++;
            if(ll<rr) swap(nums,ll,rr);
        }
        swap(nums,ll,left);
        
        if(ll == target) return;
        else if(ll < target) quickSort(nums,ll+1,right,target);
        else quickSort(nums,left,ll-1,target);
    }
}

class Solution2 {
    
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int target = len - k;

        while(true){
            int index = partition(nums,left,right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right){
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        
        int pivot = nums[left];
        int ll = left;
        int rr = right;

        while( ll < rr){
            while(ll < rr && nums[rr] >= pivot){
                rr-- ;
            }
            if( ll < rr){
                nums[ll] = nums[rr];
            }
            while(ll < rr && nums[ll] <= pivot){
                ll++ ;
            }
            if( ll < rr){
                nums[rr] = nums[ll];
            }
        }
        nums[ll] = pivot;
        return ll;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}