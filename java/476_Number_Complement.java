class Solution {
    public int findComplement(int num) {
        return findComplement2(num);
    }

    /**
     * find mask of all 1's by moving num 
     * @param num
     * @return
     */
    public int findComplement1(int num) {
        int temp = num;
        int result = 0;
        while(temp != 0){
            temp >>= 1;
            result = (result << 1) + 1;
        }
        return num ^ result;
    }
    /**
     * find mask of all 1's by using bitwise and
     */
    public int findComplement2(int num) {
        int mask = 1;
        while( (num & mask) != num){
            mask = (mask << 1) + 1;
        }
        return num ^ mask;
    }
}