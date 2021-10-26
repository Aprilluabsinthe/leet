package Q16_20_T9;

import java.util.*;
import CtCILibrary.CtCILibrary.*;

public class Combinations {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }
        
        dfs(digits, 0 , new StringBuilder());
        return combinations;
    }
    
    public void dfs(String digits, int index, StringBuilder sb) {
        if(sb.length() == digits.length()){
            combinations.add(sb.toString());
            return;
        }
        
        String options = letters.get(digits.charAt(index));
        
        for(char option : options.toCharArray()){
            sb.append(option);
            dfs(digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }

    public static HashMapList<String, String> initializeDictionary(String[] words) {
		/* Create hash table that maps from a letter to the digit */
		HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap();
		
		/* Create word -> number map */
		HashMapList<String, String> wordsToNumbers = new HashMapList<String, String>(); 
		for (String word : words) {
			String numbers = convertToT9(word, letterToNumberMap);
			wordsToNumbers.put(numbers, word);
		}
		return wordsToNumbers;
	}
	
	public static ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
		return dictionary.get(numbers);
	}
    
    public static void main(String[] args) {
		HashMapList<String, String> dictionary = initializeDictionary(AssortedMethods.getListOfWords());
		ArrayList<String> words = letterCombinations("8733", dictionary);
		for (String w: words) {
			System.out.println(w);
		}	

	}
}
