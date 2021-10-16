public class Q5_04_Next_Number {
    public static int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while( ((c & 1) == 0) && (c != 0) ){
            c0++;
            c >>= 1;
        }

        while( (c & 1) == 1 ){
            c1++;
            c >>= 1;
        }

        if(c0 + c1 == 31 || c0 + c1 == 0){
            return -1;
        }

        int p = c0 + c1;

        n |= (1 << p)
        n &= ~((1 << p) - 1);
        n |= (1 << (c1-1))-1;
        System.out.println(n + ": " + Integer.toBinaryString(n));
        return n;
    }

    public static int getPrev(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while( ((c & 1) == 1)){
            c1++;
            c >>= 1;
        }

        if(c == 0){
            return -1;
        }

        while( (c & 1) == 0 && (c != 0) ){
            c0++;
            c >>= 1;
        }



        if(c0 + c1 == 31 || c0 + c1 == 0){
            return -1;
        }

        int p = c0 + c1;

        n &= ((~0) << (p+1));
        int mask = (1 << (c1+1))-1; 
        n |= mask << (c0-1);
        System.out.println(n + ": " + Integer.toBinaryString(n));
        return n;
    }

    public static void binPrint(int i) {
		System.out.println(i + ": " + Integer.toBinaryString(i));		
	}

    public static void main(String[] args) {
		int i = 13948;
		int p1 = getPrev(i);
		int n1 = getNext(i);
		binPrint(p1);
		binPrint(n1);
	}

}
