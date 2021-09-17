class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, ArrayList<String>> ans = new HashMap<>();
        for (String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        cict Q-10.2
        List<String> cict = new ArrayList<>();
        for(String key : ans.keySet()){
            ArrayList<String> contents = ans.get(key);
            for(String str : contents){
                cict.add(str);
            }
        }
        cict.forEach(System.out::println);
        
//         Arrays.sort(strs, new Comparator<String>(){
//             @Override
//             public int compare(String s1, String s2){
//                 Arrays.sort(s1.toCharArray());
//                 String news1 = new String();
//                 Arrays.sort(s2.toCharArray());
//                 String news2 = new String();
//                 return news1.compareTo(news2);
//             }
//         });
        
//         for(String str:strs){
//             System.out.println(str);
//         }
        
        
        return new ArrayList(ans.values());
    }
    
    public List<String> groupAnagrams1(String[] strs) {
        if(strs.length == 0 ) return new ArrayList();
        Map<String, List> ans = new HashMap<>();
        Arrays.sort(strs, (String s1, String s2) -> (s1.compareTo(s2)));
        return Arrays.asList(strs);
    }
}