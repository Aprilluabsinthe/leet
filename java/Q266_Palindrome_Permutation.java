public class Q266_Palindrome_Permutation {
    public static boolean canPermutePalindrome1(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        int[] checker = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            if(checker[s.charAt(i) - 'a'] == 0){
                checker[s.charAt(i) - 'a']++; 
            }else{
                checker[s.charAt(i) - 'a']--; 
            }
        }
        
        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(checker[i] > 0){
                count++;
                if(count > 1) return false;
            }
        }
        return count <= 1;
    }
    
    public static boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        
        int checker = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ') continue;

            int val = s.charAt(i) - 'a';
            checker ^= ( 1 << val ); //0->1, 1->0
        }
            
        int count = 0;
        while(checker!=0){
            checker = (checker-1) & checker;
            count++;
        }
        return count<=1;
    }
    
    public int numbersOfOne(int num){
        int count = 0;
        while(num!=0){
            num = (num-1) & num;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac",
							"asda"};
		for (String s : strings) {
			boolean a = canPermutePalindrome(s);
			boolean b = canPermutePalindrome(s);
			boolean c = canPermutePalindrome(s);
			System.out.println(s);
			if (a == b && b == c) {
				System.out.println("Agree: " + a);
			} else {
				System.out.println("Disagree: " + a + ", " + b + ", " + c);
			}
			System.out.println();
		}

	}
}
