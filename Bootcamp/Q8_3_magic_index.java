import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Q8_3_magic_index {
    List<Integer> record = new ArrayList<>();

    public static int findMagicIndex(int array[]){
        List<Integer> res = new LinkedList<Integer>();
        return findMagicIndex(array,0,array.length-1);
    }

    public static int recurse(int array[], int left, int right){
        if(array == null || left > right){
            return -1;
        }

        int midIndex = left + (right-left) / 2;
        if(midIndex == array[midIndex]) return midIndex;
        else if(array[midIndex] > midIndex) return recurse(array,left,midIndex-1);
        else return recurse(array,midIndex+1,right);
    }

    public static int findMagicIndex(int array[], int left, int right){
        if(array == null || left > right){
            return -1;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == array[mid]){
                return mid;
            }
            else if(mid > array[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static List<Object> findMagicFollowUp(int array[]){
        List<Integer> record = new ArrayList<Integer>();
        findMagicFollowUp(record,array,0,array.length-1);
        Object[] arr = record.toArray();
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }

    public static void findMagicFollowUp(List<Integer> record,int array[],int left,int right){
        if(left > right) return;
        
        int mid = left + (right - left)/2;

        if(mid == array[mid]){
            record.add( mid );
        }

        findMagicFollowUp(record,array, left, Math.min(mid-1,array[mid]));
        findMagicFollowUp(record,array,Math.max(mid+1,array[mid]),right);
        
        return;
    }

    public static List<Integer> findsimple(int array[]){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
                res.add(i);
			}
		}
		return res;
    }

    public static int[] getDistinctSortedArray(int size) {
		int[] array = new int[size];
        Random r = new Random();
        for (int i = 1; i < array.length; i++) {
            array[i] = r.nextInt(size);
        }
		Arrays.sort(array);
		return array;
	}

    public static void main(String[] args){
        int array[] = getDistinctSortedArray(10);
        // array.forEach(System.out::println);
        Arrays.stream(array).forEach(System.out::println);
        // assert findsimple(array) == findMagicIndex(array);
        System.out.println("compare:");
        System.out.println(findsimple(array));
        System.out.println(findMagicFollowUp(array));
        System.out.println(findMagicIndex(array));
        System.out.println(recurse(array,0,array.length-1));
    }
}
