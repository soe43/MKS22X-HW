public class Driver{

    public static void main(String[] args){
	MazeSolver m = new MazeSolver(args[0], true);
	for(int i = 0;i < 5;i++){
	    m.solve(i);
	}
    }
}
