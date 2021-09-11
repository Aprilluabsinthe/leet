public class Q1_01_Is_Unique {

	/* Assumes only letters a through z. */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static boolean isUniqueChars1(String str){
		if(str.length() > 26){
			return false;
		}
		int checker = 0;
		for(char c: str.toCharArray()){
			int value = (int)(c-'a');
			if((checker & (1 << value)) > 0) return false;
			else checker |= (1 << value);
		}
		return true;
	}

	public boolean isUnique(String astr) {
        int[] record = new int[26];
        Arrays.fill(record,0);
        for(int i  = 0 ; i < astr.length() ; i++){
            if (record[astr.charAt(i) - 'a'] != 0){
                return false;
            }
            record[astr.charAt(i) - 'a'] += 1;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars1(word));
		}
	}

}