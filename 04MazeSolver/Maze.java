import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    public char[][] maze;
    private String mazeString;
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
    }

    private void readFile(String inputF) throws FileNotFoundException{
	File inputFile = new File(inputF);
	Scanner inf = new Scanner(inputFile);
	while(inf.hasNextLine()){
	    mazeString += inf.nextLine();
	}
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
