import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    private boolean animate; 
    private int startx = 0;
    private int starty = 0;
    private int endx = 0;
    private int endy = 0;

    public Maze(String inputF){
	try{
	readFile(inputF);
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found.");
	    System.exit(1);
	}	    
	for(int i = 0;i <  maze.length;i++){
	    for(int k = 0;k < maze[0].length;k++){
		if(maze[i][k] = 'S' || maze[i][k] == 's'){
		    startx = i;
		    starty = k;
		}
		if(maze[i][k] = 'E' || maze[i][k] == 'e'){
		    endx = i;
		    endy = k;
		}
	    }
	}
    }

    private void readFile(String inputF) throws FileNotFoundException{
	File inputFile = new File(inputF);
	Scanner inf = new Scanner(inputFile);
	while(inf.hasNext()){
	    maze += inf.next();
	}
    }

    public boolean solve(){
	solveH(0,0);
    }

    private boolean solveH(int startX,int startY){
	return true;
    }
    
    public static void main(String[]args){
	if(args.length > 1){
	    System.out.println("Too many arguments. Input just one file");
	    System.exit(1);
	}
	try{
	Maze M = new Maze(args[0]);
	}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Please input a file");
	    System.exit(1);
	}
	//M.solve;
	//M.toString();
    }
}
