import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    /*
     * Complete the function below.
     */
    static int[] prefixSum(String[] inputs) {
        int[] result = new int[inputs.length];
        for(int i = 0 ; i < inputs.length ; i++){
            result[i] = zAlgorithm(inputs[i].toCharArray());
        }
        return result;
    }
    
    static int zAlgorithm(char[] charArray) {
        int[] z = new int[charArray.length];
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int k = 0 ; k < charArray.length ; k++){
            if( k > right){
                left = right = k;
                while(right < charArray.length && charArray[right]==charArray[right-left]){
                    right++;
                }
                z[k] = right-left;
                right--;
            }
            else{
                // inside box
                int k1 = k - left;
                // not reaching the boundary
                if(z[k1] + k - 1 < right){
                    z[k] = z[k1];
                }
                else{
                   left = k;
                   while( right < charArray.length && charArray[right] == charArray[right-left]){
                       right++;
                   }
                   z[k] = right - left;
                   right--;
                }
            }
            sum += z[k];
            // System.out.println(z[k]);
        }
        // System.out.println(z);
        return sum + charArray.length;
    }
    

    public static void main(String[] args) throws IOException{