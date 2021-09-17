import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 
   /*
   * Complete the function below.
   */



    static int[] MergeSort(int[] values) {
        if(values.length < 2) return values;
        splitAndMerge(values,0,values.length-1);
        return values;
    }
    
    static void splitAndMerge(int[] values, int left, int right) {
        if(left >= right) return;
        //[left,right)
        int mid = 0;
        if(left < right){
            mid = left + ( right - left )/2;
            splitAndMerge(values, left , mid);
            splitAndMerge(values, mid+1, right);
            merge(values, left , mid , right);
        }
    }
    
    static void merge(int[] values, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        // temp arrays
        int[] temp = new int[right-left+1];
        int tempIdx = 0;
        while(i <= mid && j <= right){
            // descending order
            if(values[i] >= values[j]) temp[tempIdx++] = values[i++];
            else temp[tempIdx++] = values[j++];
        }
        // not yet finished
        while(i <= mid) temp[tempIdx++] = values[i++];
        while(j <= right) temp[tempIdx++] = values[j++];
        
        tempIdx = 0;
        int copyIdx = left;
        while(copyIdx <= right) values[copyIdx++] = temp[tempIdx++];
    }
    
    public static void main(String[] args) throws IOException{public class mergeSort {
        
    }
    