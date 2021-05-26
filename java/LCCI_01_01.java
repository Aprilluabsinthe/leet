class Solution {
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
}