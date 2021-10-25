public class Q16_1_NumberSwapper {

	
	public static void swap_opt(int a, int b) {
		a = a^b; 
		b = a^b; 
		a = a^b; 
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	public static void main(String[] args) {
		int a = 1672;
		int b = 9332;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		swap_opt(a, b);
	}
}
