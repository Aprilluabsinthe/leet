import java.util.*;

public class Q16_06_Smallest_Difference {
    private static int findSmallestDifferenceA(int[] array1, int[] array2) {
        if(array1 == null || array2 == null) return -1;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int index1 = 0, index2 = 0;
        int smallestGap = Integer.MAX_VALUE;

        while(index1 < array1.length && index2 < array2.length){
            int diff = Math.abs(array1[index1] - array2[index2]);
            smallestGap = Math.min(smallestGap,diff);

            if(array1[index1] > array2[index2]){
                index2++;
            }else if(array1[index1] < array2[index2]){
                index1++;
            }else{
                return 0;
            }
        }
        return smallestGap;
    }

    private static int findSmallestDifferenceB(int[] shorter, int[] longer) {
        if(shorter.length == 0 || longer.length == 0) return -1;
        if(shorter.length > longer.length) return findSmallestDifferenceB(longer,shorter);
        Arrays.sort(shorter);

        int minGap = Integer.MAX_VALUE;

        for(int i : shorter){
            int closeValue = getCloestValue(longer,i);
            minGap = Math.min(minGap,Math.abs(closeValue-i));
        }
        return minGap;
    }

    private static int getCloestValue(int[] array, int target) {
        int low = 0;
        int high = array.length-1;
        int mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(array[mid] < target){
                low = mid + 1;
            }else if(array[mid] > target){
                high = mid - 1;
            }else{
                return array[mid];
            }
        }
        int valueA = low < 0 || low >= array.length ? Integer.MAX_VALUE : array[low];
        int valueB = high < 0 || high >= array.length ? Integer.MAX_VALUE : array[high];
        return Math.abs(valueA - target ) < Math.abs(valueB - target ) ? valueA : valueB;
    }
    
    public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int differenceA = findSmallestDifferenceA(array1, array2);
		System.out.println(differenceA);

        int differenceB = findSmallestDifferenceB(array1, array2);
		System.out.println(differenceB);
	}


}
