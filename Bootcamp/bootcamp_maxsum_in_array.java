import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static int maxDifference(int[] a) {
        int n = a.length;
        
        if(a == null || n < 2){
            return 0;
        }
        if(n == 2){
            return a[1]-a[0];
        }
        
        int maxDiff = a[1]-a[0];
        int diff = a[1]-a[0];
        int curSum = diff;
        
        for(int i = 1 ; i < n-1 ;i++){
            diff = a[i+1] - a[i];
            if(curSum > 0){
                curSum += diff;  
            }else{
                curSum = diff;
            }
            maxDiff = Math.max(maxDiff,curSum);
        }
        return maxDiff <= 0 ? -1 : maxDiff;
    }
    
    static int maxDifference1(int[] a) {
        int n = a.length;
        
        if(a == null || n < 2){
            return 0;
        }
        // if(n == 2){
        //     return a[1]-a[0];
        // }
        
        int maxDiff = Integer.MIN_VALUE;
        int minNum = a[0];
        
        for(int i = 1 ; i < n ;i++){
            if(a[i] - minNum > maxDiff){
                maxDiff = a[i] - minNum;
            }
            if(a[i] < minNum){
                minNum = a[i];
            }
        }
        return maxDiff <= 0 ? -1 : maxDiff;
        
    }

    public static void main(String[] args) throws IOException {