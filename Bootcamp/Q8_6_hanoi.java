public class Q8_6_hanoi {
    public static void hanoi(int n, char source, char destination,char buffer){
        if(n <= 1){
            System.out.println("Move disk 1 from source "+
            source+" to destination "+destination);
                           return;
        }

        hanoi(n-1,source,buffer,destination);
        System.out.println("Move disk "+ n + " from source " +
        source +" to destination " + destination );
        hanoi(n-1,buffer,destination,source);
    }

    public static void  main(String args[]){
        int n = 4; // Number of disks
        hanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}
