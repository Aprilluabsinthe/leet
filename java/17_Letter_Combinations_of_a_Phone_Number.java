package java.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if(digits.length()==0 || digits==null){
            return combinations;
        }

        Map<Character,String> phoneMap = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
        backtrack(combinations, phoneMap,digits,0,new StringBuffer());
        return combinations;
    }


    public static void backtrack(List<String> combinations,Map<Character,String> phoneMap,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }
        else{
            char digit = digits.charAt(index);
            String options = phoneMap.get(digit);
            int letterCount = options.length();
            for(int i = 0 ; i < letterCount ; i++){
                combination.append(options.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }
    
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String digits = stringToString(line);
            
            List<String> ret = new Solution().letterCombinations(digits);
            
            String out = stringListToString(ret);
            
            System.out.print(out);
        }
    }
}