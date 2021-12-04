/*
#   Doordash App
#   Search bar
#   Query: ramen
#   Result: ramen #1, ramen #2 ...
#   Integer N to determine the most size of the query result.


# How can we determine the candidate is related to the query?
# prefix matching

# ramen 
# ramen #1 (O), ramen #2 (O), tokyo ramen (X)

# Input:
# a list of queries             [ ]
# a list of restaurants (DB)    [ ]
# a list of restaurans location 
# N 
# current location

# Output:
# [[Query1 result], [Query2 result], [].....]
*/
import java.util.*;

class Solution{
        // restaurants [ ]
    // String 
    // binary search : Ramen
    // left right /  mid - ramen 
    // 
    public static List<List<String>> getQuery(int N, List<String> queries, List<String> restaurants){
        // checks
        if(queries == null || restaurants == null) return new ArrayList<>();
        
        // 
        List<List<String>> res = new ArrayList<>();
        // sort restaurants
        
        for(int i = 0 ; i < restaurants.size() ; i++){
            String tmp = restaurants.get(i);
            restaurants[i] = tmp.toLowerCase();
        }
        
        Collections.sort(restaurants);
        
        for(String query : queries){
            query = query.toLowerCase();
            List<String> tmp = new ArrayList<>();
            int index = 0;
            
            // binary search for each query
            int left = 0;
            int right = restaurants.size();
            int  mid = left + (right - left )/ 2;
            int insideIndex = -1;
            while(left < right){
                mid = left + (right - left )/ 2;
                if( restaurants.get(mid).indexOf(query) == 0){
                    insideIndex = mid;
                    break;
                }else if(restaurants.get(mid).compareTo(query) > 0){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            
            // find range
            if(insideIndex == -1){
                res.add(new ArrayList<>());
            }else{
                // expand left and right
                left = insideIndex;
                right = insideIndex+1;
                while(right - left < N){
                    if(left >= 0 && restaurants.get(left).indexOf(query) == 0){
                        tmp.add(restaurants.get(left));
                        left--;
                    }
                    if(right < restaurants.size() && restaurants.get(right).indexOf(query) == 0){
                        tmp.add(restaurants.get(right));
                        right++;
                    }else{
                        break;
                    }
                }
                res.add(tmp);
            }
            // for( String restaurant : restaurants){
            //     restaurant = restaurant.toLowerCase();
            //     if(restaurant.indexOf(query) == 0){
            //         tmp.add(restaurant);
            //         index++;
            //     }
            //     if(index == N) break;
            // }
            
        }
        return res;
    }
    

    
    public static void main(String[] args){
        int N = 3;
        List<String> queries = Arrays.asList("Ramen","salad","steak");
        List<String> restaurants = Arrays.asList("ramen 1","Ramen 2","tykyo ramen","salad 2","salad 1","salad 3","salad 4","5 salad", "steak 1");
        List<List<String>> res = getQuery(N, queries, restaurants);
        for (List<String> strs : res){
            for(String str : strs){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}


package javascript;

public class doordash {
    
}
