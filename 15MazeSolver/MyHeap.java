import java.util.ArrayList;

public class MyHeap{
    private ArrayList<Location> myHeap;
    private int modifier;

    // construct empty max heap
    public MyHeap(){
	myHeap = new ArrayList<Location>();
	modifier = 1;
	myHeap.add(null);
    }
    
    // true: construct empty max heap, false: construct empty min heap.
    public MyHeap(boolean maxmin){  
	if(maxmin){
	    //make max-heap
	    myHeap = new ArrayList<Location>();
	    myHeap.add(null);
	    modifier = 1;
	}
	else{
	    //make min-heap
	    myHeap = new ArrayList<Location>();;
	    myHeap.add(null);
	    modifier = -1;
	}
   }
 
    
    //Public Methods
    public void add(Location s){
	myHeap.add(s);
	pushUp(myHeap.lastIndexOf(s));
    }
    
    public Location remove(){
	Location temp = myHeap.get(1); 
	swap(myHeap.size() - 1,1);
	myHeap.remove(myHeap.size() - 1);
	pushDown(1);
	return temp;
    }
    
    public Location peek(){
	return myHeap.get(1);
    }

    public int getSize(){
	return myHeap.size() - 1;
    }
   
    //Private Methods
    private int parent(int pos){
	return (pos) / 2;
    }
    
    private int rChild(int pos){
	return (2*pos)+1;
    }

    private int lChild(int pos){
	return 2*pos;
    }

    private void swap(int startS , int switchS){
        Location temp = myHeap.get(startS);
	myHeap.set(startS,myHeap.get(switchS));
	myHeap.set(switchS,temp);
    }

    private void pushUp(int pos){
	if(pos == 1){
	    return;
	}
	if(myHeap.get(parent(pos)).compareTo(myHeap.get(pos))*modifier < 0){
	    swap(parent(pos),pos);
	    pushUp(parent(pos));
	}
    }

    private void pushDown(int pos){
	if(lChild(pos) >= myHeap.size() || rChild(pos) >= myHeap.size()){
	    return;
	}
	if(myHeap.get(lChild(pos)).compareTo(myHeap.get(pos))*modifier > 0){
	    swap(pos,lChild(pos));
	    pushDown(lChild(pos));
	}
	if(myHeap.get(rChild(pos)).compareTo(myHeap.get(pos))*modifier > 0){
	    swap(pos,rChild(pos));
	    pushDown(rChild(pos));
	}
    }
    
    public String toString(){
	String out = "";
	for(Location s : myHeap){
	    out += s + " ";
	} 
	System.out.println();
	return out;
    }
	    
}

 
