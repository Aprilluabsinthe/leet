class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0;
        int high = people.length-1;
        int res = 0;

        while (low <= high){
            if (people[low] + people[high] <= limit) {
                res += 1;
                high -= 1;
                low += 1;
            }
            else{
                res += 1;
                high -= 1;
            }
        }
        return res;
    }
}