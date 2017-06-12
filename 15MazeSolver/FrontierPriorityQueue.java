public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue pq;
    private boolean aStar;
    private int size = 0;
    
    public FrontierPriorityQueue(boolean b){
	pq = new PriorityQueue();
	aStar = b;
    }

    public int size(){
	return size;
    }

    public boolean aStar(){
	return aStar;
    }
    
    public void add(Location a){
	pq.add(a);
	size++;
    }

    public Location next(){
	size--;
	return pq.remove();
    }

}
