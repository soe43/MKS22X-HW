public class KnightBoard{
    public int[][] board;
    private final int[] rowChoose = {-2, -1, 1, 2};
    private final int[] colChoose = {-2, -1, 1, 2};

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for(int i = 0;i < board.length;i++){
	    for(int k = 0;k < board[0].length;k++){
		board[i][k] = 0;
	    }
	}
    }

    public void solve(){ 
	solveH(0,0,0);
    }

    public boolean solveH(int row, int col, int level){
	if(level == board.length * board[0].length){
	    return true;
	}
	for(int i = 0;i < rowChoose.length;i++){
	    for(int k = 0;k < colChoose.length;k++){
		if(rowChoose[i] + colChoose[k] == 3 || rowChoose[i] + colChoose[k] == -3 || rowChoose[i] + colChoose[k] == 1 || rowChoose[i] + colChoose[k] == -1 ){
		    if((row - rowChoose[i] > 0 &&  row - rowChoose[i] < board.length) && (col - colChoose[k] > 0 && col - colChoose[k] < board.length)){
			if(board[row + rowChoose[i]][col + colChoose[k]] == 0){
				if(solveH(row+rowChoose[i],col+colChoose[i],level + 1)){
				    board[row][col] = level;
				}
			    }
		    }
		}
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
