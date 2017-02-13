public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public Queenboard(int size){
	board = new int[size][size];
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board[0].length;i++){
		board[i][k] == 0;
	    }
	}
    }

    //Wrapper function for solveH.
    public boolean solve(){
	return solveH(0);
    }

    //Method that solves for one possible solution of a given board.
    private boolean solveH(int col){
	if(col >= board.length){
	    return true;
	}
	if(board.length == 2 || board.length == 3){
	    return false;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[row][col] == 0){
		addQueen(row,col);
		return solveH(col+1);
	    }
	    if(row >= board.length){
		return false;
	    }
	}

    }
    
    //Adds a queen to row,column and adds all of the danger markers that it threatens
    private void addQueen(int row,int col){
	for(int i = 0;i<board.length;i++){
	    board[row][i] += 1;
	    board[i][col] += 1;
	    if(i < row){
		if(i < col){
		    board[row - i][col - i] += 1;
		}else{
		    board[row - i][col + i] += 1;
		}
	    }
	    if(i > row){
		if(i < col){
		    board[row + i][col - i] += 1;
		}else{
		    board[row + i][col + i] += 1;
		}
	    }
	}
    }

    //Removes the queen in row,column and removes all of the danger markers it added to the board.
    private void removeQueen(int row,int col){
	for(int i = 0;i < board.length;i++){
	    board[row][i] -= 1;
	    board[i][col] -= 1;
	    if(i < row){
		if(i < col){
		    board[row - i][col - i] -= 1;
		}else{
		    board[row - i][col + i] -= 1;
		}
	    }
	    if(i > row){
		if(i < col){
		    board[row + i][col - i] -= 1;
		}else{
		    board[row + i][col + i] -= 1;
		}
	    }
	    board[row][col] == 0;
	}
    }

    //Finds all possible solutions to an N-sized board.
    public void countSolutions(){
    }

    //Calculates the number of all possible solutions for an N-sized board.
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
