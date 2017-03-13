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
	    }
	}
	if(startx == 0 || starty == 0 || endx == 0 || endy == 0){
	    throw new IllegalArgumentException("File does not contain a start or an end.");
	}
	animate = false;
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
	int r = 0;
	while(inf.hasNextLine()){
	    temp = inf.nextLine();
	    for(int i = 0;i < temp.length();i++){
		maze[r][i] = temp.charAt(i);
	    }
	    r++;
	}
    }

    public boolean solve(){
	maze[startx][starty] = '@';
	return solveH(startx,starty);
    }

    private boolean solveH(int startX,int startY){
	if(animate){
	    System.out.println("\033[2]\033[1;1H"+this);
	    wait(100);
	}
	if(startX == endx && startY == endy){
	    return true;
	}
	maze[startX][startY] = '@';
	if(validMove(startX + 1, startY) && solveH(startX+1,startY)){
	    return true;
	}
	if(validMove(startX, startY + 1) && solveH(startX,startY+1)){
	    return true;
	}
	if(validMove(startX - 1, startY) && solveH(startX-1,startY)){
	    return true;
	}
	if(validMove(startX, startY - 1) && solveH(startX,startY-1)){
	    return true;
	}
	maze[startX][startY] = '.';
	return false;
    }
    
    private boolean validMove(int x,int y){
	if(maze[x][y] == '#' || maze[x][y] == '.' || maze[x][y] == '@'){
	    return false;
	}
	else{
	    return true;
	}
    }
    
    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }
    
    public void setAnimate(boolean b){
	animate = b;
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }
    
    public String toString(){
	String layout = "";
	for(int i = 0; i < maze.length;i++){
	    for(int k = 0; k < maze[0].length;k++){
		layout += maze[i][k];
		if(k == maze[0].length - 1){
		    layout += "\n";
		}
	    }
	}
	return layout;
    }
}
