import CiCtLibrary.AssortedMethods;

public class Q5_07_Pairwise_Swap {
    public static int swapOddEvenBitsans(int x) { 
		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) ); 
	}

    public static int swapOddEvenBits(int x) { 
		return ((x & 0xaaaaaaaa) >>> 1 | (x & 0x55555555) << 1); 
	}
	
	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
        int c = swapOddEvenBits(a);
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(c));
	}
}
