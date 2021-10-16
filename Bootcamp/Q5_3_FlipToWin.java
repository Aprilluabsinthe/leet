public class Q5_3_FlipToWin {
    public static int flipBit(int a) {
		if (~a == 0) return 32;

        int curLength = 0;
        int prevLength = 0;
        int maxLength = 1;

        while(a != 0){
            if((a & 1) != 0){
                curLength++;
            }else{
                if((a & 2) == 0){
                    prevLength = 0;
                }else{
                    prevLength = curLength;
                }
            }
            maxLength = Math.max(prevLength+curLength+1, maxLength);
            a >>>= 1;
        }
        return maxLength;
	}
	
	public static void main(String[] args) {
		int[][] cases = {{-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, 
				{1, 2}, {15, 5}, {1775, 8}};
		for (int[] c : cases) {
			int x = flipBit(c[0]);
			boolean r = (c[1] == x);
			System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
		}

	}

}
