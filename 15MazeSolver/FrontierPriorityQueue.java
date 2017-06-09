public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue pq;

    public FrontierPriorityQueue(){
	pq = new PriorityQueue();
    }
    
    public void add(Location a){
	pq.add(a);
    }

    public Location next(){
	return pq.remove();
    }

}
