import java.util.*;

public class Quick{
    
    private static int part(int[] data, int start, int end){
	int left = start;
	int right = end;
	Random r = new Random();
	int pivot = r.nextInt(end - start);
	int pivotValue = data[pivot];
	System.out.println(pivotValue);
	switchPos(data,pivot,right);
	right--;
	for(int i = start;i < end;i++){
	    if(data[i] < pivotValue){
		switchPos(data,i,left);
		left++;
	    }else{
		switchPos(data,i,right);
		right--;
	    }
	}
        switchPos(data,left,end);
	return left;
    }
    
    private static void switchPos(int[] ary, int position1, int position2){
	int temp = ary[position1];
	ary[position1] = ary[position2];
	ary[position2] = temp;
    }

    public static String toString(int[] toPrint){
	String layout = "[";
	for(int i = 0; i < toPrint.length;i++){
	    if(i == toPrint.length - 1){
		layout += toPrint[i];
	    }else{
		layout += toPrint[i] +", ";
	    }
	}
	layout+="]";
	return layout;
    }

    public static void main(String[] args){
	Random r = new Random();
	int[][] arys = new int[5][8];
	for(int i = 0;i < 5;i++){
	    for(int k = 0;k < 8;k++){
		arys[i][k] = r.nextInt(50);
	    }
	}
	for(int i = 0; i < 5; i++){
	    System.out.println(toString(arys[i]));
	    System.out.println(part(arys[i],0,arys[i].length - 1));
	    System.out.println(toString(arys[i]));
	    System.out.println();
	}
    }

}
