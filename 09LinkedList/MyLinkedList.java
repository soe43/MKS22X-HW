public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public boolean addStart(int value){
	LNode a = new LNode(value,start);
	start = a;
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String layout = "[";
	for(int i = 0;i < size;i++){
	    //To be implemented later
	}
	layout += "]";
	return layout;
    }
    

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index,int newValue){
	LNode a = getNthNode(index);
	int temp = a.value;
	getNthNode.value = newValue;
	return temp;
    }	

    private LNode getNthNode(int n){
	if(n >= size() || n < 0){
	    throw new IndexOutOfBoundsException();
	}
	LNode a = start;
	for(int i = 0;i < n;i++){
	    a = a.next;
	}
	return a;
    }
	
	    

    private class LNode{
	public int value;
	private LNode next;
	
	public LNode(int input){
	    value = input;
	    next = null;
	}

	public LNode(int input, LNode next){
	    value = input;
	    this.next = next;
	}
    }
}
	
