package Q16_11_Diving_Board;

import java.util.*;

public class QuestionA {
    public static int counter = 0;
    
    public static HashSet<Integer> allLengths(int k ,int shorter, int longer){
        HashSet<Integer> res = new HashSet<Integer>();
        getAllLengths(k,0,shorter,longer,res);
        return res;
    }

    private static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> res) {
        counter++;
        if(k == 0){
            res.add(total);
            return;
        }
        getAllLengths(k-1,total+shorter,shorter,longer,res);
        getAllLengths(k-1,total+longer,shorter,longer,res);
    }

    public static void main(String[] args) {
		HashSet<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths.toString());
		System.out.println(counter);
	}

}
