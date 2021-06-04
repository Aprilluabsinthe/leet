class Solution {
    public boolean isPowerOfFour(int n) {
        int x = 4;
        while( x > 0 && x < n){
            x <<= 2;
        }
        return n == 1 || n == x;
    }
}