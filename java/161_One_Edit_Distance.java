public class 161_One_Edit_Distance {
    int lens = 0;
    int lent = 0;
    int[] checkS = new int[26];
    int[] checkT = new int[26];
    
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        if(s.equals(t)) return false;
        
        lens = s.length();
        lent = t.length();
        if(Math.abs(lens-lent) > 1) return false;

        
        int idx1 = 0, idx2 = 0;
        while(idx1 < lens && idx2 < lent){
            if(s.charAt(idx1) == t.charAt(idx2)){
                idx1++;
                idx2++;
            }else{
                String snext = s.substring(idx1+1);
                String tnext = t.substring(idx2+1);
                return snext.equals(tnext) || s.substring(idx1).equals(tnext) || snext.equals(t.substring(idx2));
            }
        }
        return true;
    }
    
    public boolean isOneEditDistance1(String s, String t) {
        if(s == null || t == null) return false;
        if(s.equals(t)) return false;
        
        lens = s.length();
        lent = t.length();
        
        if(Math.abs(lens-lent) > 1) return false;
        
        if(lens-lent == 1){
            // only one add/delete
            return isInserted(t,s);         
            
        }else if(lent-lens == 1){
            return isInserted(s,t); 
        }else{
            return isChanged(s,t);            
        }
        
    }
    
    public boolean isChanged(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) == s2.charAt(index2)){
                index1++;
                index2++;
            }else{
                index2++;
                index1++;
                count++;
            }
        }
        return count == 1;
    }
    
    public boolean isInserted(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        if(s1.length() == 0) return true;
        
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) == s2.charAt(index2)){
                index1++;
                index2++;
            }else{
                if(index1 != index2) return false;
                index2++;
            }
        }
        return true;
    }
}
