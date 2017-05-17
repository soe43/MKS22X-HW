public class MazeSolver{
    private Maze board;
    private boolean animate;
    private static final int DEPTH_FIRST = 0;
    private static final int BREADTH_FIRST = 1;
    private static final int BEST_FIRST = 2;
    private static final int ASTAR = 3; 

    public MazeSolver(String filename){
	this(filename,false);
    }

    public MazeSolver(String filename, boolean animate){
	this.animate = animate;
	board = new Maze(filename);
    }

    public void solve(){
	solve(1);
    }

    public void solve(int style){
	if(style == DEPTH_FIRST){
	}
	if(style == BREADTH_FIRST){
	}
	if(style == BEST_FIRST){
	}
	if(style == ASTAR){
	}
    }

    public String toString(){
	return board;
    }

}

