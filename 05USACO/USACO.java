import java.util.*;
import java.io.*;

public class USACO{
    //BRONZE PROBLEM
    private int[][] lake;
    private int[][] instructions;
    private int finalElevation;
    private int numInstructions;
    private int answer;
    //SILVER INSTANCE VARIABLES
    private int r1,c1,r2,c2,row,col,seconds,solutions;
    char[][] pasture;
    
    //empty default constructor
    public USACO(){

    }

    public int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner scan = new Scanner(f);
	    
	    int row = Integer.parseInt(scan.next());
	    int col = Integer.parseInt(scan.next());
	    lake = new int[row][col];
	    
	    finalElevation = Integer.parseInt(scan.next());
	    numInstructions = Integer.parseInt(scan.next());
	    
	    int temp = 0;
	    while(temp < row){
		for(int i = 0; i < col; i++){
		    lake[temp][i] = Integer.parseInt(scan.next());
		}
		temp++;
	    }
	    
	    instructions = new int[numInstructions][3];
	    int temp1 = 0;
	    while(temp1 < numInstructions){
		for(int i = 0; i < 3; i++){
		    if(i < 2){
			instructions[temp1][i] = Integer.parseInt(scan.next()) - 1;
		    }
		    else{
			instructions[temp1][i] = Integer.parseInt(scan.next());
		    }
		}
		temp1++;
	    }
	    
	    for(int i = 0;i < instructions.length;i++){
		toStomp(instructions[i][0],instructions[i][1],instructions[i][2]);
	    }
	    
	    //
	    int totalDepth = 0;
	    for(int r = 0; r < row; r++){
		for(int c = 0; c < col; c++){
		    lake[r][c] = finalElevation - lake[r][c];
		    if(lake[r][c] > 0){
			totalDepth += lake[r][c];
		    }
		}
	    }
	    
	    answer = totalDepth * 72 * 72;
	}catch(FileNotFoundException e){
	    System.out.println("no file");
	    System.exit(1);
	}
	return answer;
    }
    private void toStomp(int r, int c, int stomp){
	int largest = 0;
	for(int i = 0; i < 3;i++){
	    for(int k = 0;k < 3;k++){
		if(lake[r+i][c+k] > largest){
		    largest = lake[r+i][c+k];
		}
	    }
	}
	//Elevation after largest has been stomped
	int newHighestElevation = largest - stomp;
	if(stomp > largest){
	    newHighestElevation = 0;
	}
	for(int i = 0;i < 3;i++){
	    for(int k = 0;k < 3;k++){
		if(lake[r+i][c+k] > newHighestElevation){
		    lake[r+i][c+k] = newHighestElevation;
		}
	    }
	}	    	    
    }
    
    //==========================================================================================
    public int silver(String filename){
	readFile(filename);
	return silverH(r1,c1,seconds);
    }

    private void readFile(String filename){
	Scanner scan = new Scanner(filename);
	row = Integer.parseInt(scan.next());
	col = Integer.parseInt(scan.next());
	seconds = Integer.parseInt(scan.next());
        pasture = new char[row][col];
	String temp = "";
	for (int i = 0;i < row;i++){
	    for(int k = 0;k < col;k++){
		temp = scan.next();
		pasture[i][k] = temp.charAt(0);
	    }
	}
	r1 = Integer.parseInt(scan.next());
	c1 = Integer.parseInt(scan.next());
	r2 = Integer.parseInt(scan.next());
	c2 = Integer.parseInt(scan.next());
    }

    private int silverH(int startR,int startC, int remainingS){
        if(startR == r2 && startC == c2 && seconds == 0){
	    solutions++;
	}else{
	    if(isValid(startR + 1, startC) && seconds > 0){
		silverH(startR + 1,startC,remainingS - 1);
	    }
	    if(isValid(startR, startC + 1) && seconds > 0){
		silverH(startR,startC + 1,remainingS - 1);
	    }
	    if(isValid(startR - 1, startC) && seconds > 0){
		silverH(startR - 1,startC,remainingS - 1);
	    }
	    if(isValid(startR, startC - 1) && seconds > 0){
		silverH(startR,startC - 1,remainingS - 1);
	    }
	}
	return solutions;
    }

    private boolean isValid(int r, int c){
	return (r >= 0 && r < pasture.length && c >= 0 && c < pasture[0].length && pasture[r][c] == '.');
    }
    //testsss
    public static void main(String[] args){
	USACO m = new USACO();
	System.out.println(m.bronze("test.txt"));
    }
    
}
    

	
   
