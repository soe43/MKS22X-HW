import java.util.Queue;

public class QueueFrontier implements Frontier{
    private Queue<Location> locations;
    private boolean aStar = false;
    public int size = 0;
    
    public Location next(){
	size--;
	return locations.remove();
    }

    public int size(){
	return size;
    }
    
    public boolean aStar(){
	return aStar;
    }

    public void add(Location a){
	locations.add(a);
	size++;
    }
}
