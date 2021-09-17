public class Q10_05_Sparse_Search {
	public static int search(String[] strings, String str, int first, int last) {
		if (first > last) {
			return -1;
		}
		
		/* Move mid to the middle */
		int mid = (last + first) / 2;
		
		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) { 
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
			
		/* Check for string, and recurse if necessary */
		if (str.equals(strings[mid])) { // Found it!
			return mid;
		} else if (strings[mid].compareTo(str) < 0) { // Search right
			return search(strings, str, mid + 1, last);
		} else { // Search left
			return search(strings, str, first, mid - 1);
		}
	}	
		
	public static int search_ans(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}
		return search(strings, str, 0, strings.length - 1);
	}
		
	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}
		// return search(strings, str, 0, strings.length - 1);
        int left = 0;
        int right = strings.length - 1;
        int mid = -1;
        while(left <= right){
            System.out.format("left : %d\n",left);
            System.out.format("right : %d\n",right);
            mid = left + (right - left ) / 2;
            // what if midStr is empty?
            // find the nearest non-empty string
            System.out.format("mid : %d\n",mid);
            System.out.format("strings[mid]: %s\n",strings[mid]);

            if(strings[mid] == ""){
                int lcursor = mid - 1;
                int rcursor = mid + 1;
                while(true){
                    if(lcursor < left && rcursor > right){
                        return -1;
                    }
                    if( lcursor >= left && !strings[lcursor].isEmpty()){
                        mid = lcursor;
                        System.out.format("mid change to: %d\n",lcursor);
                        System.out.format("strings[lcursor]: %s\n",strings[lcursor]);
                        break;
                    }
                    if( rcursor <= right &&  !strings[rcursor].isEmpty()){
                        mid = rcursor;
                        System.out.format("mid change to: %d\n",rcursor);
                        System.out.format("strings[rcursor]: %s\n",strings[rcursor]);
                        break;
                    }
                    lcursor--;
                    rcursor++;
                }
            }

            // if(mid == -1) return -1;
            if(str.equals(strings[mid])) return mid;
            else if (str.compareTo(strings[mid]) > 0) left = mid + 1;
            else if(str.compareTo(strings[mid]) < 0) right = mid - 1;
        }
        return -1;
	}
	
	public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search_ans(stringList, "apple"));
        System.out.println(search(stringList, "apple"));
        
		//for (String s : stringList) {
		//	String cloned = new String(s);
        //	System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
		//}
	}
}
