public class bootcamp_pangrams {
    
}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static String isPangram(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for(String each : strings){
            sb.append(singleIsPangram(each)); 
        }
        return sb.toString();
    }
    
    static int singleIsPangram(String string) {
        if(string.length() < 26){
                return 0;
        }
        for(int i = 97 ; i <= 122 ; i++){
            if(string.indexOf( (char) i ) != -1){
                continue;
            }
            else{
                return 0;
            }
        }
        return 1;
    }
    

    public static void main(String[] args) throws IOException {