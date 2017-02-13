public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public Queenboard(int size){
	board = new int[size][size];
	for(int i = 0;i<board.size;i++){
	    for(int k = 0;k<board[0].size;i++){
		board[i][k] == 0;
	    }
	}
    }

    public boolean solve(){
	return solveH(0);
    }

    private boolean solveH(int col){
	if(col > board.size){
	    return checkSolution();
	}
	for(int row = 0;row < board.size;row++){
	    if(canAddQueen?(row,col)){
		    addQueen(row,col);
		}
	}
    }
    	    
    private boolean canAddQueen?(int row,int col){
	for(int i = 0;i<board.size;i++){
	    if(board[row][col] == -1 && (board[row][i] > 0 || board[row][i] == -1) || (board[i][col] > 0 || board[i][col] == -1) ||((board[row - i][col - i] > 0 || board[row - i][col - i] == -1) && (i < row && i < col)) || ((board[row + i][col + i] == -1 || board[row+i][col+i] > 0) && (i<board.size - row && i<board.size - col))){
		return false;
	    }
	}
	return true;
    }
	
    private void addQueen(int row,int col){
	for(int i = 0;i<board.size;i++){
	    board[row][i] += 1;
	    board[i][col] += 1;
	    if(i < row && i < col){
		board[row - i][col - i] += 1;
	    }
	    if(i > row && i > col){
		board[row + i][col + i] += 1;
	    }
	    board[row][col] == -1;
	}
    }
		

    public int getSolutionCount(){
	return -1;
    }

    public String toString(){
	String layout = "[ ";
	for(int i = 0;i<board.size;i++){
	    for(int k = 0;k<board.size;k++){
		if(board[i][k] == -1){
		    layout += "Q ";
		}
		if(board[i][k] == 0 || board[i][k] >= 1){
		    layout += "_ ";
		}
		if(i != 0 && k == 0){
		    layout += "[ ";
		}
		if(k == 7){
		    layout += " ]";
		}
	    }
	}
    }
