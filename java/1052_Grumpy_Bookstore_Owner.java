class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int total = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0){
                total += customers[i];
                customers[i] = 0;
            }
        }

        int maxx = 0, cur = 0;

        int j = 0;
        for(int i = 0 ; i < n ; i++){
            cur += customers[i];
            if(i - j + 1 > minutes) cur -= customers[j++];
            maxx = Math.max(maxx, cur);
        }

        return total + maxx;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int ans = 0;
        int max = 0, cur = 0, total = 0;
        int r = 0, l = 0;
        int window = 0, extraSati = 0;
        while(r < n){
            total += (1-grumpy[r]) * customers[r]; // already satisfied
            window += grumpy[r] * customers[r++];
            extraSati = Math.max(extraSati, window);
            if(r - l + 1 > minutes) window -= grumpy[r] * customers[l++];
        }
        return extraSati + total;
    }
}