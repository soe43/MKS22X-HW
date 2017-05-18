import java.util.Stack;

public class StackFrontier implements Frontier{
    private Stack<Location> locations;

    public Location next(){
	return locations.pop();
    }

    public void add(Location a){
	locations.push(a);
    }
}
