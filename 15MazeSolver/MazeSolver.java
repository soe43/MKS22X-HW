import java.util.*;

public class MazeSolver{
    private Maze board;
    private boolean animate;
    private Frontier f;

    public MazeSolver(String filename){
        this(filename,false);
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
	Location start = new Location(board.getStart().row(),board.getStart().col(),null,0,distEnd(board.getStart().row(),board.getStart().col()),false);
	f.add(start);
	Location current = null;
	while(f.size() != 0){
	    current = f.next();
	    board.set(current.row(), current.col(),'.');
	    if(current.row() == board.getEnd().row() && current.row() == board.getEnd().row()){
		retrace(current);
		if(animate) System.out.println(board.toString(10));
		return;
	    }
	    else{
		ArrayList<Location> neighbors = new ArrayList<Location>();
		int row2,col2;
		row2 = current.row() + 1;
		col2 = current.col();
		if(board.get(row2,col2) == ' '){
		    board.set(row2,col2,'?');
		    if(f.aStar()){
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), true));
		    }
		    else{
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), false));
		    }
		}
		row2 = current.row() - 1;
		col2 = current.col();
		if(board.get(row2,col2) == ' '){
		    board.set(row2,col2,'?');
		    if(f.aStar()){
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), true));
		    }
		    else{
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), false));
		    }
		}
		row2 = current.row();
		col2 = current.col() + 1;
		if(board.get(row2,col2) == ' '){
		    board.set(row2,col2,'?');
		    if(f.aStar()){
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), true));
		    }
		    else{
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), false));
		    }
		}
		row2 = current.row();
		col2 = current.col() - 1;
		if(board.get(row2,col2) == ' '){
		    board.set(row2,col2,'?');
		    if(f.aStar()){
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), true));
		    }
		    else{
			neighbors.add(new Location(row2,col2,current,distStart(row2,col2),distEnd(row2,col2), false));
		    }
		}
	    }
	    if(animate) System.out.println(board.toString(10));
	}
    }

    public void retrace(Location l){
	if(l.row() == board.getEnd().row() && l.col() == board.getEnd().col()){
	    retrace(l.getPrevious());
	}
	else if(l.row() == board.getStart().row() && l.col() == board.getStart().col()){
	    return;
	}
	else {
	    board.set(l.row(),l.col(),'@');
	    retrace(l.getPrevious());
	}
    }
	

    public int distStart(int r, int c){
	return Math.abs(r - board.getStart().row()) + Math.abs(c - board.getStart().col());
    }

    public int distEnd(int r, int c){
	return Math.abs(r - board.getEnd().row()) + Math.abs(c - board.getEnd().col());
    }

    public String toString(){
	return board.toString(); //maze instance variable is maze in this case
    }

    public String toString(int n){
	return board.toString(n); //maze instance variable is maze in this case
    }	    
}

    
       
