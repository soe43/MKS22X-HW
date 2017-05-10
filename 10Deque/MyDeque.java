import java.util.*;

public class MyDeque{
    private String[] ary;
    private int front,back,size,maxSize;

    //Default initial size is 10
    public MyDeque(){
	ary = new String[10];
	front = 0;
	back = 0;
	size = 0;
	maxSize = 10;
    }

    //initialize with a size
    public MyDeque(int l){
	ary = new String[l];
	front = 0;
	back = 0;
        size = 0;
	maxSize = l;
    }

    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException();
	}
	if(size + 1 > ary.length){
	    resize();	    
	}
	else if(size == 0){
	    ary[0] = s;
	    size++;
	    front--;
	    back++;
	}
	else{
	    ary[(front % maxSize + maxSize) % maxSize] = s;
	    size++;
	    front--;
	}   
    }

    public void addLast(String s){
	if(s == null){
	    throw new NullPointerException();
	}
	if(size + 1 > ary.length){
	    resize();
	}
	else if(size == 0){
	    ary[0] = s;
	    size++;
	    front--;
	    back++;
	}
	else{
	    ary[(back % maxSize + maxSize) % maxSize] = s;
	    size++;
	    back++;
	}
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(size == 1){
	    front++;
	    back--;
	    size--;
	    return ary[(front % maxSize + maxSize) % maxSize];
	}
	else{
	    front++;
	    size--;
	    return ary[(front % maxSize + maxSize) % maxSize];
	}
    }
    
    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(size == 1){
	    front++;
	    back--;
	    size--;
	    return ary[(back % maxSize + maxSize) % maxSize];
	}
	else{
	    back--;
	    size--;
	    return ary[(back % maxSize + maxSize) % maxSize];
	}
    }

    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[((front+1) % maxSize + maxSize) % maxSize];
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[((back-1) % maxSize + maxSize) % maxSize];
    }
    
    private void resize(){
	String[] temp = new String[(size+1)*2];
	for(int i = 0;i < ary.length;i++){
	    temp[i] = ary[i];
	}
	ary = temp;
	maxSize = (size+1)*2;
    }
    /*
    public static void main(String[] args){
	MyDeque d = new MyDeque();
	d.addFirst("a");
	System.out.println(d.getFirst());
	d.addFirst("b");
	System.out.println(d.getFirst());
	d.addFirst("c");
	System.out.println(d.getFirst());
	d.addLast("d");
	System.out.println(d.getLast());
	d.addLast("e");
	System.out.println(d.getLast());
	d.removeFirst();
	System.out.println(d.getFirst());
    }
    */
}
