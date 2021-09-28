class Solution {
    public int longestDecomposition(String text) {
        int res = 0 ; 
        int count = 0 ;
        int n = text.length();
        
        for(int i = n-1 ; i > 0 ;i--){
            if(text.charAt(i) == text.charAt(0) && text.substring(0,n-i).equals(text.substring(i))){
                if(2 * i > n) return 2 + longestDecomposition(text.substring( n-i , i));
                else if(2 * i == n) return 2;
                else return 1;
            }
        }
        return 1;
    }

    public int longestDecomposition1(String text) {
        int res = 0 ; 
        int count = 0 ;
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for(int i = 0 ,j = text.length()-1 ; i < j ; i++ , j--){
            sb1.append(text.charAt(i));
            sb2.append(text.charAt(j));
            String s1 = sb1.toString();
            String s2 = new StringBuffer(sb2).reverse().toString();
            if(s1.equals(s2)){
                count += sb1.length() * 2;
                sb1 = new StringBuffer();
                sb2 = new StringBuffer();
                res += 2;
            }
        }
        if(count != text.length()) res++;
        return res;
    }
}