import java.util.Stack;

public class StackFrontier implements Frontier{
    private Stack<Location> locations;
    private boolean aStar = false;
    private int size = 0;

    public Location next(){
	size--;
	return locations.pop();
    }

    public boolean aStar(){
	return false;
    }

    public int size(){
	return size;
    }

    public void add(Location a){
	locations.push(a);
	size++;
    }
}
