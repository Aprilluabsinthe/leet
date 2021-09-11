import java.util.Arrays;

public class Q1_02_Check_Permutation {
// O(nlogn)
    // O(1)
    public static boolean isAnagram1(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
        
    }
    
    // O(n)
    // o(1)
    public static boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        
        
        char[] checker = new char[26];
        for(int i = 0 ; i < s.length() ; i++){
            int vals = (int)(s.charAt(i)-'a');
            int valt = (int)(t.charAt(i)-'a');
            checker[vals] += 1;
            checker[valt] -= 1;
        }
        
        for(int i = 0 ; i < checker.length ; i++){
            if (checker[i] != 0) return false;
        }
        
        return true;
        
        
    }

    public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = isAnagram(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}
