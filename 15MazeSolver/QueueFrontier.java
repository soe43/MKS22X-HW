import java.util.Queue;

public class QueueFrontier implements Frontier{
    private Queue<Location> locations;
    
    public Location next(){
	return locations.remove();
    }

    public void add(Location a){
	locations.add(a);
    }
}
