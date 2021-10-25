class Q16_05_Factorial_Zeros {
    public int trailingZeroes1(int n) {
        int res = 0;
        for(int i = 1 ; i <= n ; i++){
            int temp = i;
            while(temp!=0 && temp % 5 == 0){
                temp = temp / 5;
                res++;
            }
        }
        return res;
    }
    
    public int trailingZeroes2(int n) {
        int res = 0;
        for(int i = 5 ; i <= n ; i+=5){
            int power = 5;
            while(i % power == 0){
                power *= 5;
                res++;
            }
        }
        return res;
    }
    
    public static int countFactZeros(int n) {
        int res = 0;
        while(n > 0){
            n/=5;
            res += n;
        }
        return res;
    }


    public static long[] memo = new long[10000];

    public static long factorial_memo(int num) {
        if (num == 1) {
            memo[1] = 1;
			return memo[1];
		} else if (num > 1) {
            if(memo[num - 1]!=0){
                memo[num] = num * memo[num - 1];
                return memo[num];
            }else{
                memo[num] = num * factorial_memo(num - 1);
                return memo[num];
            }
		} else {
			return -1; // Error
		}
    }

    public static long factorial(int num) {
		if (num == 1) {
			return 1;
		} else if (num > 1) {
			return num * factorial_memo(num - 1);
		} else {
			return -1; // Error
		}
	}

    public static void main(String[] args) {
		for (int i = 1; i < 31; i++) {
			System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
		}
	}
}