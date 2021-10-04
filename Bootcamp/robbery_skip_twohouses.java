import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    

    static int maximumLoot(short[] loot) {
        if(loot == null) return 0;
        int n = loot.length;
        if(n == 0) return 0;
        int res = 0;
        int maxPrevThree = 0;
        
        if(n == 1) return (int)loot[0];
        if(n == 2) return (int)Math.max(loot[0],loot[1]);
        if(n == 3) return (int)Math.max( Math.max(loot[0],loot[1]),loot[2]);
        
        int first = (int)loot[0];
        int second = (int)Math.max(loot[0],loot[1]);
        int third = (int)Math.max( Math.max(loot[0],loot[1]),loot[2]);
        
        for(int i = 3 ; i < n ; i++){
            int temp = third;
            third = (int)Math.max( first + loot[i], third);
            first = second;
            second = temp;
        }
        return third;       
    }
    
    static int maximumLoot1(short[] loot) {
        if(loot == null) return 0;
        int n = loot.length;
        if(n == 0) return 0;
        int res = 0;
        
        
        int first = (int)loot[0];
        int second = (int)loot[1];
        int third = (int)loot[2];
        int fourth = 0;
        int fifth = 0;
        res = Math.max(Math.max(first, second), third);
        int cur = 0;
        for(int i = 3 ; i < n ; i++){
            if(i == 3){
                fourth = loot[i] + first;
                res = Math.max(res, fourth);
            }
            else if(i == 4){
                fifth = loot[i] + Math.max(first,second);
                res = Math.max(fifth, res);
            }
            else{
                cur = loot[i] + Math.max(Math.max(first,second),third);
                first = second;
                second = third;
                third = fourth;
                fourth = fifth;
                fifth = cur;
                res = Math.max(res, cur);
            }
            // System.out.print(dp[i]);
            // System.out.print(" ");;
        }
        
        return res;

    }
// see http://www.jstatsoft.org/v08/i14/paper for definition of xorshift RNG
    static int seed = 123456;
    static int xorshift() {
       seed ^= (seed << 1);
       seed ^= (seed >> 3);
       seed ^= (seed << 10);
       return seed & 0x7FFFFFFF;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        
        int _loot_size = Integer.parseInt(in.nextLine().trim());
        short[] _loot = new short[_loot_size];
        if (_loot_size <= 100) {
            for(int _loot_i = 0; _loot_i < _loot_size; _loot_i++) {
                _loot[_loot_i] = (short)Integer.parseInt(in.nextLine().trim());
            }
        } else {
            seed = Integer.parseInt(in.nextLine().trim());
            for(int _loot_i = 0; _loot_i < _loot_size; _loot_i++) {
                _loot[_loot_i] = (short)((xorshift() % 100) + 1) ;
            }
        }

        PrintStream err = System.err ;
        System.setErr(System.out);
        try {
            int res = maximumLoot(_loot);
            bw.write(String.valueOf(res));
            bw.newLine();
        } catch (Exception e) {
            printException(err,e);
        }
        bw.close();
    }

    private static void printException(PrintStream err, Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        for (int i = 0; i < trace.length; ++i) {
            if (trace[i].getClassName().equals("Solution")) {
                err.println(e.getClass().getName()+" at line "+trace[i].getLineNumber());
                System.exit(1);
            }
        }
        err.println(e.getClass().getName());
        System.exit(1);
    }
}