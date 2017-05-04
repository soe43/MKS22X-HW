import java.util.ArrayList;

public class MyHeap{
    private ArrayList<String> myHeap;
    private int modifier;

    // construct empty max heap
    public MyHeap(){
	myHeap = new ArrayList<String>();
    }
    
    // true: construct empty max heap, false: construct empty min heap.
    public MyHeap(boolean maxmin){  
	if(maxmin){
	    //make max-heap
	    myHeap = new ArrayList<String>();
	    modifier = 1;
	}
	else{
	    //make min-heap
	    myHeap = new ArrayList<String>();
	    modifier = -1;
	}
   }
 
    
    //Public Methods
    public void add(String s){}
    
    public String remove(){}
    
    public String peek(){}

    //Private Methods
    private int parent(int pos){
	return pos / 2;
    }
    
    private int rChild(int pos){
	return (2*pos)+1;
    }

    private int lChild(int pos){
	return 2*pos;
    }

    private boolean isChild(int pos){
    }

    private void swap(int startS , int switchS){
	String temp = myHeap.get(startS);
	myHeap.set(startS,myHeap.get(switchS));
	myHeap.set(switchS,temp);
    }

    private void pushUp(int pos){
	if(myHeap.get(parent(pos)).compareTo(myHeap.get(pos)) < 0){
	    swap(parent(pos),pos);
	    pushUp(parent(pos));
	}
    }

    private void pushDown(int pos){
	if(myHeap.get(lChild(pos)).compareTo(myHeap.get(pos)) < 0){
	    swap(pos,lChild(pos));
	    pushDown(lChild(pos));
	}
	if(myHeap.get(rChild(pos)).compareTo(myHeap.get(pos)) < 0){
	    swap(pos,rChild(pos));
	    pushDown(rChild(pos));
	}
    }
}

 
