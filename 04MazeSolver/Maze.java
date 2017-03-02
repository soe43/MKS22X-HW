import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    private String mazeString;
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
	System.out.println(row+" "+col);
	maze = new char[row][col];
	try{
	    for(int i = 0;i < row;i++){
		for(int k = 0;k < col;k++){
		    maze[i][k] = inf.next().charAt(0);
		}
	    }
	}catch(NoSuchElementException e){
	    return;
	}
	/*
	while(inf.hasNext()){
	    mazeString += inf.next(); 
	}
	System.out.println("done");
	System.out.println(mazeString);
	Scanner t = new Scanner(mazeString);
	Scanner f = new Scanner(mazeString);
	t.useDelimiter("/n");
	while(t.hasNextLine()){
	    col = col + 1;
	}
	System.out.println("done");
	row = f.nextLine().length();
	System.out.println("done");
	*/
    }

    public boolean solve(){
	solveH(0,0);
	return false;
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
