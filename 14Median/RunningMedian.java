public class RunningMedian{
    private MyHeap big;
    private MyHeap small;

    public RunningMedian(){
	big = new MyHeap(true);
	small = new MyHeap(false);
    }

    public void add(int a){
        if(big.getSize() == 0 || a < big.peek()){
	    big.add(a);
	}
	else{
	    small.add(a);
	}
	if(big.getSize() > small.getSize() + 1){
	    small.add(big.remove());
	}
	else if(small.getSize() > big.getSize() + 1){
	    big.add(small.remove());
	}  
    }

    public double getMedian(){
	if(big.getSize() - small.getSize() == 1){
	    return big.peek();
	}
	else if(big.getSize() - small.getSize() == -1){
	    return small.peek();
	}
	else{
	    return ((double)big.peek() + (double)small.peek())/2;
	}
    }

    /*
    public static void main(String[] args){
	RunningMedian r = new RunningMedian();
	r.add(1);
	System.out.println(r.getMedian()); //1
	r.add(2);
	System.out.println(r.getMedian()); //1.5
	r.add(3);
	System.out.println(r.getMedian()); //2
    }
    */	
}


	
