import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class BoardPosition {
    int num_rows ;
    int num_columns ;
    int row ;
    int column ;

    BoardPosition(int rows, int columns) {
        num_rows = rows;
        num_columns = columns;
        row = column = 0;
        return;
    }

    BoardPosition(BoardPosition pos) {
        num_rows = pos.num_rows;
        num_columns = pos.num_columns;
        row = pos.row;
        column = pos.column;
        return;
    }

    void check_validity() {
        if (row < 0 || row >= num_rows
            || column < 0 || column >= num_columns) {
            row = column = -1;
        }
        return;
    }

    boolean valid() {
        return row != -1 && column != -1;
    }

    BoardPosition move(char how) {
        BoardPosition new_pos = new BoardPosition(this);
        if (how == 'U') {
            new_pos.row--;
        } else if (how == 'D') {
            new_pos.row++;
        } else if (how == 'L') {
            new_pos.column--;
        } else if (how == 'R') {
            new_pos.column++;
        } else { // how == '*'
            // position is unchanged
        }
        new_pos.check_validity();
        return new_pos.valid() ? new_pos : null;
    }
}
    
public class Solution {

    static int minimum_ops1(char[][] board, int time_K, int row, int column) {
        
        
        if(board == null || board.length == 0) return -1;
        int num_rows = board.length;
        int num_cols = board[0].length;
        
        for(int i = 0 ; i < num_rows ; i++){
            for(int j = 0 ; j < num_cols ; j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        
        int[][] flips = new int[num_rows][num_cols];
        for(int r  = 0 ; r < num_rows ; r++){
            Arrays.fill(flips[r],Integer.MAX_VALUE);
        }
        
        dfs(board, 0,0,flips,0,0,time_K);
        return flips[row][column] != Integer.MAX_VALUE ? flips[row][column] : -1; 
    }
    
    static boolean inBoard(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
    
    static void dfs(char[][] board, int i, int j, int[][] flips , int curFlip, int curTime, int time_K){
        if(!inBoard(board, i, j) || curFlip >= flips[i][j]) return;
        flips[i][j] = curFlip;
        if (board[i][j] == '*' || curTime == time_K) return;
        
        dfs(board , i-1 , j , flips , board[i][j] == 'U' ? curFlip : curFlip+1 , curTime+1 , time_K);
        dfs(board , i , j-1 , flips , board[i][j] == 'L' ? curFlip : curFlip+1 , curTime+1 , time_K);
        dfs(board , i+1 , j , flips , board[i][j] == 'D' ? curFlip : curFlip+1 , curTime+1 , time_K);
        dfs(board , i , j+1 , flips , board[i][j] == 'R' ? curFlip : curFlip+1 , curTime+1 , time_K);
    }
    
    static int minimum_ops(char[][] board, int time_K, int row, int column) {
        if(board == null || board.length == 0) return -1;
        
        int num_rows = board.length;
        int num_cols = board[0].length;
        
        if(num_rows == 0 || num_cols == 0) return 0;
        
        Boolean ori = check_original(board,time_K,row,column);
        
        for(int i = 0 ; i < num_rows ; i++){
            for(int j = 0 ; j < num_cols ; j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.format("* position : %d %d \n", row,column);
        System.out.format("check_original: %b \n", ori);
        
        if(ori){
            return 0;
        }
        else{
            // has to change
            BoardPosition bp = new BoardPosition(num_rows,num_cols);
            int[][] flips = new int[num_rows][num_cols];
            for(int r  = 0 ; r < num_rows ; r++){
                Arrays.fill(flips[r],Integer.MAX_VALUE);
            }
            dfsMove(board, flips, 0, row, column, bp , time_K);
            return flips[row][column] == Integer.MAX_VALUE ? -1 : flips[row][column];
        }
    }
    
    static void dfsMove(char[][] board, int[][] flips , int curFlip, int asterisk_row, int asterisk_col, BoardPosition bp, int time_left) {
        if((bp == null) || (time_left == 0 && (bp.row != asterisk_row || bp.column != asterisk_col)) || curFlip >= flips[bp.row][bp.column] ) return;
        
        flips[bp.row][bp.column] = curFlip;
        if(time_left >= 0 && bp.row == asterisk_row && bp.column == asterisk_col ) return;
        
        char[] options = new char[]{'U','L','D','R'};
        char[] rev_options = new char[]{'D','R','U','L'};
        
        char origin = board[bp.row][bp.column];
        for(int oi = 0 ; oi < 4 ; oi++){
            char option = options[oi];
            // no need to flip
            if(option == origin){
                BoardPosition new_pos = bp.move(option);
                dfsMove(board, flips, curFlip , asterisk_row, asterisk_col, new_pos , time_left-1);
            } 
            else{
                // have to flip
                BoardPosition new_pos = bp.move(option);
                dfsMove(board, flips, curFlip+1 , asterisk_row, asterisk_col, new_pos , time_left-1);
            }
        }
    }
    
    static Boolean check_original(char[][] board, int time_K, int row, int column) {
        int num_rows = board.length;
        int col_rows = board[0].length;
        BoardPosition bp = new BoardPosition(num_rows,col_rows);
        
        // whether it reaches "*" after K times of movement
        int i = 0;
        int dx = 0, dy = 0;
        
        while( i < time_K ){
            System.out.format("board[bp.row][bp.column]: %c \n",board[bp.row][bp.column]);
            bp = bp.move(board[bp.row][bp.column]);
            if(bp == null) return false;;
            
            i++;
        }
        
        if(board[bp.row][bp.column] == '*') return true;
        return false;
    }

    public static void main(String[] args) throws IOException{