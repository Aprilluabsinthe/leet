## Q1 Tic Tac Win:

**Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic-tac-toe.

// 3*3

// 2 players A B

// ------

//| 1 |  |  | -> sum of row 3 / -3

// ------

//|  | 1 |  |

// ------

//|  |  |1  |

// ------

//| -> sum of col 3 / -3

// A : 1

// B : -1

// inputs?: board  / fill up

// boolean tie or not

```java
public static boolean winOrNot(int[][] board){
	if(board == null ) return false;

	Row = board.length;
	Col = board[0].length;

	if(row != 3 || col != 3){
Return false;
}

for(int r = 0 ; r < row ; r++){
	If checkRow(board,r) return true;
}

for(int c = 0 ; c < col; c++){
	If checkCol(board,c) return true;
}

If checkDiag(board) return true;

Return false;


}

public static boolean checkRow(int[][] board, int row){
	Int sum = 0;
	for(int i = 0 ;i < board[0].length;i++){
	Sum += board[row][i];
}
If (sum == 3 || sum == -3) return true;
Else turn false;
}

public static boolean checkCol(int[][] board, int col){
	Int sum = 0;
	for(int i = 0 ;i < board.length;i++){
	Sum += board[i][col];
}
If (sum == 3 || sum == -3) return true;
Else turn false;
}

public static boolean checkDiag(int[][] board){
	Int sum1 = 0;
	sum1 = board[0][0] + board[1][1] + board[2][3];

Int sum2 = 0;
	sum2 = board[0][2] + board[1][1] + board[2][0];

	Return (sum1 == 3 || sum1 == -3) || (sum2 == 3 || sum2 == -3);
}

```

## Q2 Minesweeper

Minesweeper: Design and implement a text-based Minesweeper game. Minesweeper is the classic single-player computer game where an NxN grid has B mines (or bombs) hidden across the grid. The remaining cells are either blank or have a number behind them. The numbers reflect the number of bombs in the surrounding eight cells. The user then uncovers a cell. If it is a bomb, the player loses. If it is a number, the number is exposed. If it is a blank cell, this cell and all adjacent blank cells (up to and including the surrounding numeric cells) are exposed. The player wins when all non-bomb cells are exposed. The player can also flag certain places as potential bombs. This doesn't affect game play, other than to block the user from accidentally clicking a cell that is thought to have a bomb. (Tip for the reader: if you're not familiar with this game, please play a few rounds on line first.)

Objects:

```java
Type : enum{ boom - number - blank}

Cell{
	Int row;
	Int col;
	Type ;
	Boolean hasExposed ; 
	Boolean Hasflaged;

construction
Setter getter 

click(){
	Num : 
}

flag(){
//guess
!hasExposed
-> Hasflaged
}

}

Board // {
	Int rows;
Int cols;
Cell[][];
Cell[] bombs


Initialization
getClickableCells()
clickCell(Cell c);
exposeBlank(Cell c);
}

UserAction(click on which cell / indicate a flag){
	// choose a cell + operations
	Int row;
	Int col;
	Boolean flag;
	clickCell(int row, col);
FlagCell(int row, col);

}

GamerController{
	Board;
	List<UserActions>

	Initial_game
	Start
end
	judge_winOrnot
}

```



## Q3 Insertion

Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space to fit all of M. That is, if M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.

EXAMPLE

Input: N

M = 10011

Output: N

SOLUTION 10000000000, M 10001001100

```java
public static int insert(int N, int M, int i ,int j){
if( i > j || i < 0 || j > 31) return 0;
int higgermask =  -1 << (j+1);// 11111111000000000000000
int lowermask = (1 << i)-1;// 000000010000000i )1111111 
int clear_mask = higgermask & lowermask ;//  11111111(j0)0000(i0)1111111 

// clear from i to j
N &= clear_mask;// N:-------00000000--------------
int insert_m = (M << i) //--------(01101)0000000
return N |  insert_m ; //N:--------01101-------------




}

```
