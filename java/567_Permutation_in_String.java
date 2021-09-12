class Solution {
    int[] checker = new int[26];
    
    // O(l1 + 26*(l2-l1))
    // O(1)
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2){
            return false;
        }
        
        fillChecker(s1);
        // System.out.println(checker.toString());
        
        int[] record = new int[26];
        
        // original char
        for(int i = 0 ; i < len1 ; i++){
            record[s2.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(record,checker)) return true;
        
        int j = 0;
        while(j < len2-len1){
            record[s2.charAt(j) - 'a']--;
            record[s2.charAt(j+len1) - 'a']++;
                
            if(Arrays.equals(record,checker)) return true;
            
            j++;
        }
        return false;
        
    }
    
    
    public void fillChecker(String s1) {
        for(int i = 0 ; i < s1.length() ; i++){
            checker[s1.charAt(i) - 'a']++;
        }
    }
}