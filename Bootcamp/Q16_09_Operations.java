import CtCILibrary.CtCILibrary.AssortedMethods;

public class Q16_09_Operations {
    public static int negate(int a){
        // int neg = 0;
        // int newSign = a < 0 ? 1 : -1;
        return ~a+1;
        
    }

    public static int minus(int a , int b){
        return a + negate(b);
    }

    public static int abs(int a){
        if(a < 0){
            return negate(a);
        }
        return a;
    }

    public static int multiply(int a, int b){
        if(a < b){
            return multiply(b, a);
        }

        int sum = 0;
        for(int i = 0; i < Math.abs(b) ; i++){
            sum += a;
        }
        if(b < 0){
            sum = negate(sum);
        }
        return sum;
    }

    public static int divide(int a, int b) throws java.lang.ArithmeticException{
        if(b == 0){
            throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
        }
        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;
        while(product + absb <= absa){
            product += absb;
            x++;
        }

        if((a < 0 && b < 0) || (a > 0 && b > 0)){
            return x;
        }else{
            return negate(x);
        }
    }

    public static void main(String[] args) {
		int minRange = -100;
		int maxRange = 100;
		int cycles = 100;
		
		for (int i = 0; i < cycles; i++) {
			int a = AssortedMethods.randomIntInRange(minRange, maxRange);
			int b = AssortedMethods.randomIntInRange(minRange, maxRange);
			int ans = minus(a, b);
			if (ans != a - b) {
				System.out.println("ERROR");
			}
			System.out.println(a + " - " + b + " = " + ans);
		}
		for (int i = 0; i < cycles; i++) {
			int a = AssortedMethods.randomIntInRange(minRange, maxRange);
			int b = AssortedMethods.randomIntInRange(minRange, maxRange);
			int ans = multiply(a, b);
			if (ans != a * b) {
				System.out.println("ERROR");
			}
			System.out.println(a + " * " + b + " = " + ans);
		}
		for (int i = 0; i < cycles; i++) {
			int a = AssortedMethods.randomIntInRange(minRange, maxRange);
			int b = AssortedMethods.randomIntInRange(minRange, maxRange);
			System.out.print(a + " / " + b + " = ");
			int ans = divide(a, b);
			if (ans != a / b) {
				System.out.println("ERROR");
			}
			System.out.println(ans);
		}
	}

}
