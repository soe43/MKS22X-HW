import java.util.*;

public class Quick{

    private static int part(int[]data){
	return part(data,0,data.length-1);
    }
    
    private static int part(int[] data, int start, int end){
	if(data.length == 0){
	    return 0;
	}
	Random r = new Random();
	int pivot = start + r.nextInt(end - start);
	int pivVal = data[pivot];
        swap(data,pivot,end);
	int i = start;
	int lt = start;
	int rt = end-1;
	while(i <= rt){
	    if(data[i] < pivVal){
		swap(data,lt,i);
		i++;
		lt++;
	    }
	    else if(data[i] > pivVal){
		swap(data,i,rt);
		rt--;
	    }
	    else{
		i++;
	    }
	}
	swap(data,end,i);
	return i;
    }

    private static void swap(int[] ary, int position1, int position2){
	int temp = ary[position1];
	ary[position1] = ary[position2];
	ary[position2] = temp;
    }
    
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length - 1;
	while(start < end){
	    int piv = part(data,start,end);
	    if(piv < k){
		start = piv + 1;
	    }
	    else if(piv > k){
		end = piv -1 ;
	    }
	    else{
		return data[piv];
	    }
	}	    
	return data[start];
    }

    public static void quicksort(int[] data){
	quickSortH(data,0,data.length-1);
    }

    private static void quickSortH(int[] data,int start,int end){
	if(data.length <= 1){
	    return;
	}
	if(start < end){
	    int piv = part(data,start,end);
	    quickSortH(data,start,piv -1);
	    quickSortH(data,piv+1,end);
	}
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
    /*
    public static void main(String[]args){
	System.out.println("PARTITION TEST");
	Random r = new Random();
	int[][] arys = new int[10][20];
	for(int i = 0;i < 10;i++){
	    for(int k = 0;k < 20;k++){
		arys[i][k] = r.nextInt(50);
	    }
	}
	for(int i = 0;i < 10; i++){
	    System.out.println();
	    System.out.println(toString(arys[i]));
	    System.out.println(part(arys[i]));
	    System.out.println(toString(arys[i]));
	    System.out.println("");
	    quickSort(arys[i]);
	    System.out.println(toString(arys[i]));
	}
	System.out.println();
	System.out.println("QUICKSELECT TEST");
	int[] ary = {999,0,999,1,2,999,4,6};
	for(int i = 0; i < ary.length;i++){
	    if(i == 1){
		System.out.println(""+i+"st Smallest: " +quickselect(ary,i));
	    }
	    if(i == 2){
		System.out.println(""+i+"nd Smallest: " +quickselect(ary,i));
	    }
	    if(i == 3){
		System.out.println(""+i+"rd Smallest: " +quickselect(ary,i));
	    }
	    else{
		System.out.println(""+i+"th Smallest: " +quickselect(ary,i));
	    }
	}
    }
    */
}
