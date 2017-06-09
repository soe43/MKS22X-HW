public class Location implements Comparable<Location>{
    private int row,col,distToGoal,distToStart;
    private Location previous;
    private boolean aStar;
    
    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.distToGoal = distToGoal;
	this.distToStart = distToStart;
	this.previous = previous;
	this.aStar = aStar;
    }

    public int getDistStart(){
	return distToStart;
    }

    public int getDistGoal(){
	return distToGoal;
    }

    public Location getPrevious(){
	return previous;
    }

    public boolean getAStar(){
	return aStar;
    }
    
    public int compareTo(Location other){
	if(other.getAStar()){
	    return (this.distToStart + this.distToGoal) - (other.distToStart + other.distToGoal);
	}
	else{
	    return this.distToGoal - other.distToGoal;
	}
    }
}
