public class USACO{
    //SILVER INSTANCE VARIABLES
    int r1,c1,r2,c2,row,col,seconds;
    char [][] pasture;
    //BRONZE INSTANCE VARIABLES

    
    public int bronze(String filename){
	return 0;
    }

    public int silver(String filename){
	readFile(filename);
	silverH(r1,c1,seconds);
    }

    private void readFile(String filename){
	Scanner scan = new Scanner(filename);
	row = scan.next();
	col = scan.next();
	seconds = scan.next();
        pasture = new char[row][col];
	for (i = 0;i < row;i++){
	    for(k = 0;k < col;k++){
		pasture[i][k] = scan.next();
	    }
	}
	r1 = scan.next();
        c1 = scan.next();
	r2 = scan.next();
	c2 = scan.next();
    }


	
	
