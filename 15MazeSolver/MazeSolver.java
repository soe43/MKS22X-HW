public class MazeSolver{
    private Maze board;
    private boolean animate;
    private Frontier f;

    public MazeSolver(String filename){
	board = new Maze(filename);
	animate = false;
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	this.animate = animate;
    }
    
    public void solve(){
	solve(1);
    }

    public void solve(int style){
	if(style == 0){f = new StackFrontier();}
	else if(style == 1){f = new QueueFrontier();}
	else if(style == 2){f = new FrontierPriorityQueue(false);}
	else if(style == 3){f = new FrontierPriorityQueue(true);}
    }

    
       
