class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right){
            right &= (right - 1);
        }
        return right;
    }

    public int rangeBitwiseAnd1(int left, int right) {
        int i = 0 ;
        while(left != right){
            left >>= 1;
            right >>= 1;
            i += 1;
        }
        return left << i;
    }
}