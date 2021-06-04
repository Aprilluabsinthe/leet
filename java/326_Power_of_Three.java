class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThree3(int n) {
        int maxInt = Integer.MAX_VALUE;
        int maxTimes = (int)Math.floor( Math.log(maxInt) / Math.log(3) );
        int maxThree = (int)Math.pow(3,maxTimes);
        return n > 0 && maxThree % n == 0;
    }


}