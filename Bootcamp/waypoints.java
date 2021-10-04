import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    // Return a bit mask representing the power-up (if any) at location
    //   (x,y) in the level
    static int powerUpMask(int[][] level, int x, int y) {
        int powerup = level[x][y];
        return (powerup < 2) ? 0 : (1 << (powerup-2));
    }
    // Add a bit flag for the power-up (if any) at location (x,y) in the
    //   level to the previous set of power-ups
    static int addPowerUp(int oldmask, int[][] level, int x, int y) {
        return oldmask | powerUpMask(level,x,y);
    }
    // Return the bitmask representing all power-ups.
    static int allPowerUps(int powerup_count) {
        return (1 << powerup_count) - 1;
    }
    // number of possible combinations of collected powerups
    static int combinations(int powerup_count) {
        return (1 << powerup_count);
    }
    
    // A utility class which tracks position, powerups collected, and path length
    static class Path {
        int x;		    // current position in the level
        int y;
        int powerups;	// mask of powerups encountered so far
        int length;	    // number of steps taken so far

        // initialize the path at the starting location
        Path(int start_x, int start_y) {
            x = start_x; y = start_y; powerups = 0; length = 0;
        }
        // incremental update of position (internal use only)
        private Path(int new_x, int new_y, int pl, int pu) {
            x = new_x; y = new_y; powerups = pu; length = pl; 
        }

        // try to move in the indicated direction, and return a new
        //   instance at the new location if able to move
        Path move(int [][] level, int direction) {
            int new_x = x;
            int new_y = y;
            if (direction == 0) new_x--;
            else if (direction == 1) new_y--;
            else if (direction == 2) new_x++;
            else if (direction == 3) new_y++;
            else return null;
            if (new_x < 0 || new_y < 0 || new_x >= level.length || new_y >= level[0].length
                || level[new_x][new_y] == 1) return null;
            Path newpath = new Path(new_x,new_y,length+1,
                                    addPowerUp(powerups,level,new_x,new_y));
            return newpath;
        }

        // is the position of the current instance the target position?
        boolean at(int target_x, int target_y) {
            return x == target_x && y == target_y;
        }
        // have we collected all powerups on the path we've taken?
        boolean haveAll(int num_powerups) {
            return powerups == allPowerUps(num_powerups);
        }
    }


    static int minMoves(int[][] level, int in_x, int in_y, int out_x, int out_y,  int powerup_count) {
        if(level==null) return -1;
        
        Queue<Path> queue = new LinkedList<>();
        boolean[][] powervisited = new boolean[powerup_count][combinations(powerup_count)];
        
        int result = -1;
        queue.add(new Path(in_x,in_y));
        
        for(int i = 0 ; i < level.length ;i++){
            for(int j = 0 ; j < level[0].length ; j++){
                int value = level[i][j];
                if( value > 2 ){
                    powervisited[value][powerUpMask(level,i,j)] = true;
                }
            }
        }
        
        while(!queue.isEmpty()){
            Path curpath = queue.poll();
            if( curpath.haveAll(powerup_count) && curpath.at(out_x, out_y)){
                // have all powerups and reached the destination
                result = curpath.length;
                break;
            }
            
            int nullpathcount = 0;
            for(int dir = 0 ; dir < 4 ; dir++){
                Path newpath = curpath.move(level, dir);
                // if(newpath == null){
                //     nullpathcount++;
                //     continue;
                // }
                
            //     int value = level[newpath.x][newpath.y];
            //     if(value >= 2){
            //         if(!powervisited[value][newpath.powerups]){
            //             queue.add(newpath);
            //             powervisited[value][newpath.powerups] = true;
            //         }
            //     }
            // }
                
                if( newpath != null ){
                    queue.add(newpath);
                }else{
                    nullpathcount++;
                }
            }
            if(nullpathcount == 4) return -1;
        }
        return result;
        
    }
    public static void main(String[] args) throws IOException{