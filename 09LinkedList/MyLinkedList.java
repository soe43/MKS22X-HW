public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public void add(){
    }

    public String toString(){
	String layout = "";

	return layout;
    }

    private class LNode{
	public int value;
	private LNode next;
	
	public LNode(int input){
	    value = input;
	}
    }
}
	
