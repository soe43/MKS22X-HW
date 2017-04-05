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
	return add(size,value);
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
	if(index == 1 && size != 1){
	    LNode a = new LNode(value,start.next,start);
	    start.next.prev = a;
	    start.next = a;
	    size++;
	    return true;
	}
	if(index == size){
	    LNode a = new LNode(value,null,end);
	    end.next = a;
	    end = a;
	    size++;
	    return true;
	}
	else{
	    LNode a = new LNode(value);
	    addAfter(a,getNthNode(index-2));
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
	if(index == 0){
	    int temp = start.value;
	    start.value = newValue;
	    return temp;
	}
	else{
	    LNode a = getNthNode(index);
	    int temp = a.value;
	    a.value = newValue;
	    return temp;
	}
    }	

    public int remove(int index){
	if(index == 0){
	    int temp = start.value;
	    start.next.prev = null;
	    start = start.next;
	    size = size - 1;
	    return temp;
	}
	if(index == size){
	    int temp = end.value;
	    end.prev.next = null;
	    end = end.prev;
	    size = size - 1;
	    return temp;
	}
	else{
	    return remove(getNthNode(index));
	}
    }
    
    private int remove(LNode a){
	int temp = a.value;
	if(size == 0){
	    throw new IllegalArgumentException();
	}
	if(size == 1){
	    start = null;
	    end = null;
	    size=size-1;
	    return temp;
	}
	if(a.prev == null){
	    a.next.prev = null;
	    start = a.next;
	    size=size-1;
	    return temp;
	}
	if(a.next == null){
	    a.prev.next = null;
	    end = a.prev;
	    size = size - 1;
	    return temp;   
	}
	else{
	    a.prev.next = a.next;
	    a.next.prev = a.prev;
	    size=size-1;
	}
	return temp;
    }
	
    private LNode getNthNode(int n){
	if(n >= size() || n < 0){
	    throw new IndexOutOfBoundsException();
	}
	LNode a = start;
	int temp = n;
	while(temp > 0){
	    a = a.next;
	    temp--;
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
    /*
    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
        a.add(0);
	System.out.println(a.toString());
	a.add(1);
	System.out.println(a.toString());
	a.add(2);
	System.out.println(a.toString());
	a.add(3);
	System.out.println(a.toString());
	a.add(4);
	System.out.println(a.toString());
	a.add(5);
	System.out.println(a.toString());
	a.add(6,6);
	System.out.println(a.toString());
	a.add(5,7);
	System.out.println(a.toString());
	a.add(5,8);
	System.out.println(a.toString());
	a.add(0,5);
	System.out.println(a.toString());
	a.add(1,9);
	System.out.println(a.toString());
	a.remove(0);
	System.out.println(a.toString());
	a.remove(3);
	System.out.println(a.toString());
	a.set(0,4);
	System.out.println(a.toString());
	a.set(1,6);
	System.out.println(a.toString());
	System.out.println(a.get(0));
	System.out.println(a.get(4));
	System.out.println(a.size());
	System.out.println(a.get(8));
    }
    */
}
	
