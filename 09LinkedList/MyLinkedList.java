public class MyLinkedList{
    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }

    public boolean add(int value){
	add(size,value);
	return true;
    }

    public boolean add(int index, int value){
	if(index < 0 || index > size+1){
	    return false;
	}
	if(size == 0){
	    LNode a = new LNode(value);
	    start = a;
	    end = a;
	    size++;
	    return true;
	}
	if(index == 0){
	    LNode a = new LNode(value,start,null);
	    start.prev = a;
	    start = a;
	    size++;
	    return true;
	}
	if(index == size+1){
	    LNode a = new LNode(value,null,getNthNode(index));
	    end.prev = a;
	    end = a;
	    size++;
	    return true;
	}
	else{
	    LNode a = new LNode(value);
	    addAfter(a,getNthNode(index));
	    return true;
	}   
    }

    private void addAfter(LNode location, LNode toBeAdded){
	location.prev = toBeAdded;
	location.next = toBeAdded.next;
	toBeAdded.next = location;
	toBeAdded.next.prev = location;
	size++;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String layout = "[ ";
        int temp = size;
	LNode a = start;
	while(a != null){
	    layout += a.value + " ";
	    a = a.next;
	    temp--;
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
        a.value = newValue;
	return temp;
    }	

    private int remove(LNode a){
	int temp = a.value;
	if(size == 0){
	    throw new IllegalArgumentException();
	}
	if(size == 1){
	    start = null;
	    end = null;
	    size--;
	}
	if(a.prev == null){
	    start = a.next;
	    a.next.prev = null;
	    size--;;
	}
	if(a.next == null){
	    end = a.prev;
	    a.prev.next = null;
	    size--;
	}
	else{
	int val = a.value;
	a.prev.next = a.next;
	a.next.prev = a.prev;
	size--;
	}
	return temp;
    }

	
    private LNode getNthNode(int n){
	if(n >= size() || n < 0){
	    throw new IndexOutOfBoundsException();
	}
	LNode a = start;
	while(n >= 0){
	    a = a.next;
	}
	return a;
    }
	
	    

    private class LNode{
	public int value;
	private LNode next;
	private LNode prev;
	
	public LNode(int input){
	    value = input;
	    next = null;
	    prev = null;
	}

	public LNode(int input, LNode next, LNode prev){
	    value = input;
	    this.next = next;
	    this.prev = prev;
	}
    }

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
        a.add(0);
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(5);
	
	System.out.println(a.toString());
    }
}
	
