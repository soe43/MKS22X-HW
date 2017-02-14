public class QueenBoard{
    private int[][]board;
    private int solutionCount = -1;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board.length;k++){
		board[i][k] = 0;
	    }
	}
    }

    //Wrapper function for solveH.
    public boolean solve(){
	return solveH(0);
    }

    //Method that solves for one possible solution of a given board.
    private boolean solveH(int col){
	if(col == board.length){
	    return true;
	}
	if(board.length == 2 || board.length == 3){
	    return false;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[row][col] == 0){
		addQueen(col,row);
		if(solveH(col+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }else{
		removeQueen(col,row);
	    }
	}
	return false;
    }
    
    //Adds a queen to row,column and adds all of the danger markers that it threatens
    private void addQueen(int col,int row){
	board[col][row] = -1;
	for(int i = 0; i<board.length;i++){
	    if(i != col){
		board[i][row] += 1;
	    }
	    if((i - col + row >= 0) && (i - col + row < board.length) && (i != col)){
		board[i][i - col + row] += 1;
	    }
	    if ((i != col) &&  ((-1*i) + col + row >= 0) && ((-1*i) + row + col < board.length)) {
		board[i][(-1*i) + row + col] += 1;
	    }
	}
    }


    //Removes the queen in row,column and removes all of the danger markers it added to the board.
    private void removeQueen(int col,int row){
	board[col][row] += 1;
	for(int i = 0; i<board.length;i++){
	    if(i != col){
		board[i][row] -= 1;
	    }
	    if((i - col + row >= 0) && (i - col + row < board.length) && (i != col)){
		board[i][i - col + row] -= 1;
	    }
	    if ((i != row) &&  ((-1*i) + row + col >= 0) && ((-1*i) + row + col < board.length)) {
		board[i][(-1*i) + row + col] -= 1;
	    }
	}
    }

    //Finds all possible solutions to an N-sized board.
    public void countSolutions(){
    }

    //Calculates the number of all possible solutions for an N-sized board.
    public int getSolutionCount(){
	return -1;
    }

    public String debug(){
	String layout = "";
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board.length;k++){
		if(board[i][k] == -1){
		    layout += "Q ";
		}else{
		    layout += board[i][k];
		}
		if(k == board.length - 1){
		    layout += "\n";
		}
	    }
	}
	return layout;
    }
	
    public String toString(){
	String layout = "";
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board.length;k++){
		if(board[i][k] == -1){
		    layout += "Q ";
		}
		if(board[i][k] == 0 || board[i][k] >= 1){
		    layout += "_ ";
		}
		if(k == board.length - 1){
		    layout += "\n";
		}
	    }
	}
	return layout;
    }

    public static void main(String[]args){
	QueenBoard b = new QueenBoard(4);
	b.solve();
	System.out.println(b.toString());
	System.out.println(b.debug());
    }
}
