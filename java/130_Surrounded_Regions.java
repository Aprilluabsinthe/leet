package java;

class Solution {
    int n = 0;
    int m = 0;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        if (n == 0){
            return ;
        }
        for (int i = 0 ; i < n ; i++){
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }
        for (int i = 0 ; i < m ; i++){
            dfs(board, 0, i);
            dfs(board, n-1, i);
        }
        for (int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        for(int i = 0 ; i < 4 ;i++){
            dfs(board, x+dx[i], y+dy[i]);
        }
    }
}

