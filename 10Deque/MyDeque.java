public class Deque extends Queue{
    private String[] ary;
    private int front,back,end;

    //Default initial size is 10
    public Deque(){
	ary = new String[10];
	front = 0;
	back = 0;
	end = 9;
    }

    //initialize with a size
    public Deque(int size){
	ary = new String[size];
	front = 0;
	back = 0;
	end = size - 1;
    }

    public void addFirst(String s){
	if(front - 1 < 0){
	}
    }

    public void addLast(String s){
	if(back + 1 > end){
	    resize();
	}
	ary[back] = s;
	back++;
    }

    public void removeLast(String s){
	back--;
    }
    
    private void resize(){
	String[] temp = new String[(end+1)*2];
	for(int i = 0;i < ary.length;i++){
	    temp[i] = ary[i];
	}
    }
