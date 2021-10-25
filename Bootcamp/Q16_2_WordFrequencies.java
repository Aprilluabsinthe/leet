import java.util.*;

import CtCILibrary.CtCILibrary.*;

public class Q16_2_WordFrequencies {
    private static HashMap<String, Integer> setupDictionary(String[] book) {
        HashMap<String, Integer> record = new HashMap<>();
        for (String word : book){
            word = word.trim().toLowerCase();
            if(word.length()>0){
                record.put(word, record.getOrDefault(word, 0)+1);
            }
        }
        return record;
    }
    private static int getFrequency(HashMap<String, Integer> dictionary, String word) {
        if(dictionary == null || word == null || word.length() == 0) return 0;
        return dictionary.getOrDefault(word.trim().toLowerCase(), 0);
    }

    public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		Arrays.stream(wordlist).forEach(s -> {System.out.print(s);System.out.print(" ");});
        // String text = Arrays.toString(wordlist);
        // System.out.print(text);
        HashMap<String, Integer> dictionary = setupDictionary(wordlist);
		
		String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
		for (String word : words) {
			System.out.println(word + ": " + getFrequency(dictionary, word));
		}
	}
}


