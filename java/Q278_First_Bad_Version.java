/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            // while(!isBadVersion(right)){
            //     right = right*2;
            // }
            // int left = right / 2;
            
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(!isBadVersion(mid)){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return left;
        }
    }