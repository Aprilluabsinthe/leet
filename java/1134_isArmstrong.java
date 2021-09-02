public class 1134_isArmstrong {
    // there are two ways of calculating the digits
    // one is String.valueOf(n).length();
    // another is using Math.log10(n) + 1
    public boolean isArmstrong(int n) {
        int temp = n , sum = 0 , res = 0;
        // int k = String.valueOf(n).length();
        int k = (int)(Math.log10(n)) + 1;
        while( n != 0 ){
            int digit = n % 10;
            res += Math.pow(digit,k);
            n = n / 10 ;
        }
        return res == temp;

    }

    public boolean isArmstrong1(int n) {
        int res = 0;
        int ncopy = n;
        int k = 0;
        while( ncopy != 0 ){
            int digit = ncopy % 10; //3
            ncopy = ncopy / 10 ;// 15
            k += 1; //1
        }

        ncopy = n;
        while( ncopy != 0 ){
            int digit = ncopy % 10;
            ncopy = ncopy / 10 ;
            res += Math.pow(digit,k);
        }
        return res == n;
    }
}
