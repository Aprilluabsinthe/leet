public class Q16_07_Number_Max {

    public static int flip(int bit){
        return 1 ^ bit;
    }

    public static int sign(int a){
        return flip((a >> 31) & (0x1));
    }

    private static int getMaxNaive(int a, int b) {
        int sc = sign(a-b);
        return sc * a + flip(sc) * b;
    }

    public static int getMax(int a, int b){
        int c = a-b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int use_sign_a = sa ^ sb;
        int use_sign_c = flip(sa ^ sb);

        int k = use_sign_a * sa + use_sign_c * sc;
        int q = flip(k);

        return a * k + b * q;
    }

    public static void main(String[] args) {
		int a = 26;
		int b = -15;
		
		System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));		
		
		a = -15;
		b = 2147483647;
		
		System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
	}


}
