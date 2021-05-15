import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> romanMap = new HashMap<>(){
            {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
            }
        };

        int res = 0;
        for(int i = 0 ; i < s.length() -1 ; i++){
            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i+1))){
                res += romanMap.get(s.charAt(i));
            }
            else{
                res -= romanMap.get(s.charAt(i));
            }
        }
        res += romanMap.get(s.charAt(s.length() -1));
        return res;
    }
}