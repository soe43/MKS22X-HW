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
	solveH(0,0,1);
    }

    public boolean solveH(int row, int col, int level){
	if(level == board.length * board[0].length){
	    return true;
	}
	if((row + 2 > 0 && row + 2 < board.length) && (col + 1 > 0 && col + 1 < board.length)){
	    if(board[row+2][col+1] == 0){
		if(solveH(row+2,col+1,level+1)){
		    board[row][col] = level;
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
		if(solveH(row+2,col-1,level+1)){
		    board[row][col] = level;
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
		if(solveH(row+1,col+2,level+1)){
		    board[row][col] = level;
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
		if(solveH(row+2,col+1,level+1)){
		    board[row][col] = level;
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
		if(solveH(row-1,col+2,level+1)){
		    board[row][col] = level;
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
	if((row - 1 > 0 && row - 1 < board.length) && (col - 2  > 0 & col - 2 < board.length)){
	    if(board[row-1][col-2] == 0){
		if(solveH(row-1,col-2,level+1)){
		    board[row][col] = level;
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
		if(solveH(row-2,col+1,level+1)){
		    board[row][col] = level;
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
		if(solveH(row-2,col-1,level+1)){
		    board[row][col] = level;
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

    public String toString(){
	String layout = "";
	for(int i = 0;i<board.length;i++){
	    for(int k = 0;k<board[0].length;k++){
		if(k == board[0].length - 1){
		    layout = "\n";
		}else{
		layout = layout +  board[i][k] + " "; 
		}
	    }
	}
	return layout;
    }

    public static void main(String[]args){
	KnightBoard b = new KnightBoard(5,5);
	b.solve();
	System.out.println(b.toString());
    }
}
