import java.util.ArrayList;

public class MyHeap{
    private ArrayList<String> myHeap;
    private int modifier;

    // construct empty max heap
    public MyHeap(){
	myHeap = new ArrayList<String>();
	modifier = 1;
	myHeap.add("");
    }
    
    // true: construct empty max heap, false: construct empty min heap.
    public MyHeap(boolean maxmin){  
	if(maxmin){
	    //make max-heap
	    myHeap = new ArrayList<String>();
	    myHeap.add("");
	    modifier = 1;
	}
	else{
	    //make min-heap
	    myHeap = new ArrayList<String>();
	    myHeap.add("");
	    modifier = -1;
	}
   }
 
    
    //Public Methods
    public void add(String s){
	myHeap.add(s);
	pushUp(myHeap.lastIndexOf(s));
	System.out.println(myHeap.toString());
    }
    
    public String remove(){
	if(myHeap.size() == 1){
	    return "";
	}
	String temp = myHeap.get(1); 
	swap(1,myHeap.size() - 1);
	myHeap.remove(myHeap.size()-1);
	pushDown(1);
	return temp;
    }
    
    public String peek(){
	return myHeap.get(1);
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
	String temp = myHeap.get(startS);
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
	for(String s : myHeap){
	    out += s + " ";
	} 
	return out;
    }
    /*
    public static void main(String[]args){
	MyHeap h = new MyHeap();
	String[] s = {"a", "b", "c", "d"};
	for(int i = 0;i < s.length;i++){
	    h.add(s[i]);
	}
	System.out.println(h.toString());
	System.out.println();
	for(int i = 0; i < h.myHeap.size()+1;i++){
	    System.out.println(h.toString());
	    System.out.println(h.remove());
	    System.out.println(h.toString());
	}
    }
    */
	    
}

 
