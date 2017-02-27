public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board.length;k++){
		board[i][k] = 0;
	    }
	}
	solutionCount = -1;
    }

    //Wrapper function for solveH.
    public boolean solve(){
	return solveH(0,false);
    }

    //Method that solves for one possible solution of a given board.
    private boolean solveH(int col, boolean checkSolution){
	if(col == board.length){
	    if(checkSolution){
		solutionCount += 1;
		return false;
	    }else{
		return true;
	    }
	}
	if(board.length == 2 || board.length == 3){
	    return false;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(solveH(col+1,checkSolution)){
		    if(!checkSolution){
			return true;
		    }else{
			solutionCount += 1;
			return false;
		    }
		}
		else{
		    removeQueen(col,row);
		}
	    }
	}
	return false;
    }
    
    //Adds a queen to row,column and adds all of the danger markers that it threatens
    private void addQueen(int col,int row){
	board[col][row] = -1;
	for(int k = 0; k<board.length;k++){
	    if(k != col){
		board[k][row] += 1;
	    }
	    if((k - col + row >= 0) && (k - col + row < board.length) && (k != col)){
		board[k][k - col + row] += 1;
	    }
	    if ((k != col) &&  ((-1*k) + col + row >= 0) && ((-1*k) + row + col < board.length)) {
		board[k][(-1*k) + row + col] += 1;
	    }
	}
    }


    //Removes the queen in row,column and removes all of the danger markers it added to the board.
    private void removeQueen(int col,int row){
	board[col][row] += 1;
	for(int k = 0; k<board.length;k++){
	    if(k != col){
		board[k][row] -= 1;
	    }
	    if((k - col + row >= 0) && (k - col + row < board.length) && (k != col)){
		board[k][k - col + row] -= 1;
	    }
	    if ((k != col) &&  ((-1*k) + row + col >= 0) && ((-1*k) + row + col < board.length)) {
		board[k][(-1*k) + row + col] -= 1;
	    }
	}
    }

    //Finds all possible solutions to an N-sized board.
    public void countSolutions(){
	board = new int[board.length][board.length];
	solutionCount += 1;
	solveH(0,true);
    }

    //Calculates the number of all possible solutions for an N-sized board.
    public int getSolutionCount(){
	return solutionCount;
    }

    public String debug(){
	String layout = "";
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board.length;k++){
		if(board[i][k] == -1){
		    layout += "Q";
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
	QueenBoard b = new QueenBoard(10);
	b.solve();
	System.out.println(b);
	System.out.println(b.debug());
	b.countSolutions();
	System.out.println(b.getSolutionCount());
	QueenBoard c = new QueenBoard(2);
	c.solve();
	System.out.println(c);
	System.out.println(c.debug());
	c.countSolutions();
	System.out.println(c.getSolutionCount());
	QueenBoard d = new QueenBoard(1);
	d.solve();
	System.out.println(d);
	System.out.println(d.debug());
	d.countSolutions();
	System.out.println(d.getSolutionCount());
    }
}
