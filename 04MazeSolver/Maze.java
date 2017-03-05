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
		if(maze[i][k] == 'S'){
		    startx = i;
		    starty = k;
		}
		if(maze[i][k] == 'E'){
		    endx = i;
		    endy = k;
		}
		System.out.println("" + startx + starty + endx + endy);
	    }
	}
    }

    private void readFile(String inputF) throws FileNotFoundException{
	File inputFile = new File(inputF);
	Scanner inf = new Scanner(inputFile);
	Scanner infdim = new Scanner(inputFile);
	String temp = "";
	int rownum = 0;
	int colnum = 0;
	while(infdim.hasNextLine()){
	    rownum++;
	    colnum = infdim.nextLine().length();
	}
	maze = new char[rownum][colnum];
	System.out.println(rownum + " " + colnum);
	for(int r = 0;r < rownum;r++){
	    while(inf.hasNextLine()){
		temp = inf.nextLine();
		System.out.println(temp);
		for(int i = 0;i < temp.length();i++){
		    maze[r][i] = temp.charAt(i);
		}
	    }
	}
    }

    public boolean solve(){
	solveH(0,0);
	return true;
    }

    private boolean solveH(int startX,int startY){
	return true;
    }

    public String toString(){
	String layout = "";
	for(int i = 0; i < maze.length;i++){
	    for(int k = 0; k < maze[0].length;k++){
		layout += maze[i][k];
	    }
	}
	return layout;
    }
    
    public static void main(String[]args){
	if(args.length > 1){
	    throw new ArrayIndexOutOfBoundsException("Too many arguments. Input just one file");
	}
	if(args.length == 0){
	    throw new ArrayIndexOutOfBoundsException("Please input a file");
	}
	Maze M = new Maze(args[0]);
	System.out.println(M.toString());

	//M.solve;
	//M.toString();
    }
}
