public class PriorityQueue{
    private MyHeap pq;

    public PriorityQueue(){
	pq = new MyHeap(false);
    }

    public void add(Location l){
	pq.add(l);
    }

    public Location remove(){
	return pq.remove();
    }
}
