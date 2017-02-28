public class KnightBoard{
    public int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for(int i = 0;i < board.length;i++){
	    for(int k = 0;k < board[0].length;k++){
		board[i][k] = 0;
	    }
	}
    }

    public void solve(){ 
	if(board.length == 1 && board[0].length == 1){
	    board[0][0] = 1;
	}else{
	solveH(0,0,1);
	}
    }
    /*
    public boolean solveH(int row, int col, int level){
	if(level == board.length * board[0].length){
	    return true;
	}
	if((row + 2 > 0 && row + 2 < board.length) && (col + 1 > 0 && col + 1 < board.length)){
	    if(board[row+2][col+1] == 0){
		board[row][col] = level;
		if(solveH(row+2,col+1,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row + 2 > 0 && row + 2 < board.length) && (col - 1 > 0 && col - 1 < board.length)){
	    if(board[row+2][col-1] == 0){
		board[row][col] = level;
		if(solveH(row+2,col-1,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row + 1 > 0 && row + 1 < board.length) && (col + 2 > 0 && col + 2 < board.length)){
	    if(board[row+1][col+2] == 0){
		board[row][col] = level;
		if(solveH(row+1,col+2,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row + 1 > 0 && row + 1 < board.length) && (col - 2 > 0 && col - 2 < board.length)){
	    if(board[row+1][col-2] == 0){
		board[row][col] = level;
		if(solveH(row+2,col+1,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row - 1 > 0 && row - 1 < board.length) && (col + 2 > 0 && col + 2 < board.length)){
	    if(board[row-1][col+2] == 0){
		board[row][col] = level;
		if(solveH(row-1,col+2,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row - 1 > 0 && row - 1 < board.length) && (col - 2  > 0 && col - 2 < board.length)){
	    if(board[row-1][col-2] == 0){
		board[row][col] = level;
		if(solveH(row-1,col-2,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row - 2 > 0 && row - 2 < board.length) && (col + 1 > 0 && col + 1 < board.length)){
	    if(board[row-2][col+1] == 0){
		board[row][col] = level;
		if(solveH(row-2,col+1,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	if((row - 2 > 0 && row - 2 < board.length) && (col - 1 > 0 && col - 1 < board.length)){
	    if(board[row-2][col-1] == 0){
		board[row][col] = level;
		if(solveH(row-2,col-1,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		return false;
	    }
	}
	return false;
    }
    */

    /*
    private boolean solveH(int row, int col, int level){
	if(level == board.length * board[0].length){
	    return true;
	}
	if((row > 0 && row < board.length) && (col > 0 && col < board[0].length)){
	    if(board[row][col] == 0){
		board[row][col] = level;
		if(solveH(row+2, col-1, level+1)){
		    return true;
		}
		else if(solveH(row+2,col+1,level+1)){
		    return true;
		}
		else if(solveH(row+1,col+2,level+1)){
		    return true;
		}
		else if(solveH(row+1,col-2,level+1)){
		    return true;
		}
		else if(solveH(row-1,col+2,level+1)){
		    return true;
		}
		else if(solveH(row-1,col-2,level+1)){
		    return true;
		}
		else if(solveH(row-2,col+1,level+1)){
		    return true;
		}
		else if(solveH(row-2,col-1,level+1)){
		    return true;
		}
		else{
		    return false;
		}
	    }else{
		return false;
	    }
	}
	else{
	    return false;
	}
    }
    */

    public boolean solveH(int row, int col, int level){
	if(level == board.length*board[0].length + 1){
	    return true;
	}
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = level;
	if(isLegal(row - 2,col + 1) && solveH(row - 2,col + 1,level+1)){
	    return true;
	}
	if(isLegal(row - 1,col - 2) && solveH(row - 1,col - 2,level+1)){
	    return true;
	}
	if(isLegal(row + 1,col + 2) && solveH(row + 1,col + 2,level+1)){
	    return true;
	}
	if(isLegal(row + 2,col - 1) && solveH(row + 2,col - 1,level+1)){
	    return true;
	}
	if(isLegal(row - 2,col - 1) && solveH(row - 2,col - 1,level+1)){
	    return true;
	}
	if(isLegal(row + 1,col - 2) && solveH(row + 1,col - 2,level+1)){
	    return true;
	}
	if(isLegal(row - 1,col + 2) && solveH(row - 1,col + 2,level+1)){
	    return true;
	}
	if(isLegal(row + 2,col + 1) && solveH(row + 2,col + 1,level+1)){
	    return true;
	}
	board[row][col] = 0;
	level--;
	return false;
    }

    public boolean isLegal(int row,int col){
	return (row >= 0 && col >= 0 && row < board.length && col < board[0].length);
    }
    
    public String toString(){
	String layout = "";
	for(int i = 0;i<board.length;i++){
	    layout += "\n";
	    for(int k = 0;k<board[0].length;k++){
		layout +=  board[i][k] + " "; 
		}
	}
	return layout;
    }

    public static void main(String[]args){
	for(int i = 1;i < 8;i++){
	    for(int k = 1; k < 8;k++){
	    long startTime = System.currentTimeMillis();
	    KnightBoard b = new KnightBoard(i,k);
	    b.solve();
	    System.out.println(b);
	    long endTime = System.currentTimeMillis();
	    System.out.println("Time: " + ((endTime - startTime)/1000.0) + " Seconds");
	    }
	}
    }
}

