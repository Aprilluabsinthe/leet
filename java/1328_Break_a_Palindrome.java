class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        String ans = "";
        for (int i = 0 ; i < n/2 ; i++){
            if(palindrome.charAt(i) != 'a'){
                ans = palindrome.substring(0,i) + 'a' + palindrome.substring(i+1,n);
                break;
            }
            if(i == n/2 -1){
                ans = palindrome.substring(0,n-1) + 'b';
                break;
            }
        }
        if(isPalindrom(ans)){
            return "";
        }
        return ans;
    }

    public static boolean isPalindrom(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}