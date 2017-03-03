import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    private String mazeString = "";
    private int row = 0;
    private int col = 0;
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
	maze = new char[row][col];
	for(int i = 0;i <  maze.length;i++){
	    for(int k = 0;k < maze[0].length;k++){
		if(maze[i][k] == 'S' || maze[i][k] == 's'){
		    startx = i;
		    starty = k;
		}
		if(maze[i][k] == 'E' || maze[i][k] == 'e'){
		    endx = i;
		    endy = k;
		}
	    }
	}
    }

    private void readFile(String inputF) throws FileNotFoundException{
	File inputFile = new File(inputF);
	Scanner inf = new Scanner(inputFile);
	Scanner infdim = new Scanner(inputFile);
	while(infdim.hasNextLine()){
	    col = infdim.nextLine().length();
	    row++;
	}
	maze = new char[row][col];
	boolean foundS = true;
	boolean foundE = true;
	String temp = "";
	try{
	    for(int i = 0;i < row;i++){
		if(inf.hasNextLine()){
		    temp = inf.nextLine();
		}
		for(int k = 0;k < col;k++){
		    maze[i][k] = temp.charAt(0);
		    temp.substring(1);
		}
	    }
	    System.out.println(mazeString);
	}catch(NoSuchElementException e){
	    return;
	}
	if(foundE == false){
	     throw new NoSuchElementException("No End Point Found");
	}
	if(foundS == false){
	    throw new NoSuchElementException("No Start Point Found");
	}
    }

    public boolean solve(){
	solveH(0,0);
	return false;
    }

    private boolean solveH(int startX,int startY){
	return true;
    }

    public String toString(){
	String mazeS = "";
	for(int i = 0;i < maze.length;i++){
	    for(int k = 0;k < maze[0].length;k++){
		mazeS += maze[i][k];
		if(k == maze[0].length - 1){
		    mazeS += "\n";
		}		
	    }
	}
	return mazeS;
    }
    
    public static void main(String[]args){
	if(args.length > 1){
	    System.out.println("Too many arguments. Input just one file");
	    System.exit(1);
	}
	if(args.length == 0){
	    System.out.println("No Arguments. Please input a file");
	    System.exit(1);
	}
	Maze M = new Maze(args[0]);
	System.out.println(M.toString());
	//M.solve;
	//M.toString();
    }
}
