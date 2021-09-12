class Solution {
    public int compress(char[] chars) {
        // List<Char> list = Arrays.asList(chars);
        int i = 0 ; 
        int cur = 0;
        while( i < chars.length ){
            char curChar = chars[i];
            int j = i;
            while(j < chars.length && chars[j] == chars[i]) j++;
            
            String repeat = String.valueOf(j - i);
            chars[cur++] = curChar;
            if( j - i > 1){
                for(int k = 0 ; k < repeat.length() ;k++){
                    chars[cur++] = repeat.charAt(k);
                }
                
            }
            i = j;
            
        }
        
        return cur;
        
    }
}