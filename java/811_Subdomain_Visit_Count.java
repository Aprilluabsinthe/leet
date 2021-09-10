class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length == 0){
            return new ArrayList<String>();
        }
        
        Map<String,Integer> freq = new HashMap<>();
        
        for(String str : cpdomains){
            String[] arr = str.split(" ");
            // System.out.println(Arrays.toString(arr));
            
            int times = Integer.parseInt(arr[0]);
            String domains = arr[1];
            // System.out.println(arr[1]);
            // String[] subdomains = arr[1].split("\\.");
            // System.out.println(Arrays.toString(subdomains));
            
            // System.out.println(freq.toString());
            for(int i = domains.length()-1; i >=0; i--){
                if(i == 0){
                    freq.put(domains,freq.getOrDefault(domains,0)+times);
                }
                if(domains.charAt(i) == '.'){
                    String sub = domains.substring(i+1);
                    freq.put(sub,freq.getOrDefault(sub,0)+times);
                }
            }
            // System.out.println(freq.toString());
        }
        
        List<String> result = new ArrayList<>();
        
        for( Map.Entry<String,Integer> entry : freq.entrySet()){
            result.add(entry.getValue() + " " + entry.getKey() );
        }
        
        return result;
    }
}
