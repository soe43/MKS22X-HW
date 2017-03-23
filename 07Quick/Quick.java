import java.util.*;

public class Quick{
    
    private static int part(int[] data, int start, int end){
	int left = start;
	int right = end-1;
	Random r = new Random();
	int pivot = start + ((r.nextInt(end - start) + r.nextInt(end - start)) / 2);
	int pivotValue = data[pivot];
	switchPos(data,pivot,left);
	int i = left + 1;
        while(i < right){
	    if(data[i] < pivotValue){
		left++;
		i++;
	    }
	    if(data[i] > pivotValue){
		switchPos(data,i,right);
		right--;
	    }
	    else{
		i++;
	    }
	}
        switchPos(data,0,right);
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

    public static int quickselect(int[] data, int k){
	return quickselectH(data,k,0,data.length);
    }
    
    private static int quickselectH(int[] data, int k,int start,int end){
	while(end > start){
	    int pivot = part(data,start,end);
	    if(k == pivot){
		return data[k];
	    }
	    else if(k > pivot){
		return quickselectH(data,k,pivot+1,end);
	    } else {
		return quickselectH(data,k,start,pivot-1);
	    }
	}
	return data[k];
    }

    public static void quickSort(int[] ary){
	//quickSortH(ary,0,ary.length);
    }

    public static void quickSortH(int[] ary, int left, int right){
			      
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
	    System.out.println("0th Smallest: " + quickselect(arys[i],0));
	    System.out.println(toString(arys[i]));
	    System.out.println();	    
	}
	int[] ary = {999,0,999,1,2,999,4,6};
	for(int i = 0; i < ary.length;i++){
	    if(i == 1){
		System.out.println(""+i+"st Smallest: " +quickselect(ary,i));
	    }
	    else if(i == 2){
		System.out.println(""+i+"nd Smallest: " +quickselect(ary,i));
	    }
	    else if(i == 3){
		System.out.println(""+i+"rd Smallest: " +quickselect(ary,i));
	    }
	    else{
		System.out.println(""+i+"th Smallest: " +quickselect(ary,i));
	    }
	}
	
	int[] scrambled = {5,6,3,1,8,0};
	System.out.println();
	System.out.println(toString(scrambled));
	quickSort(scrambled);
	System.out.println("Sorted: \n" + toString(scrambled)); 
	System.out.println();

	int[][] scrambledArys = new int[10][10];
	for(int i = 0;i < 10;i++){
	    for(int k = 0;k < 10;k++){
		scrambledArys[i][k] = r.nextInt(10);
	    }
	}
	for(int i = 0; i < 10; i++){
	    System.out.println(toString(scrambledArys[i]));
	    quickSort(scrambledArys[i]);
	    System.out.println("Sorted: \n" + toString(scrambledArys[i]));
	    System.out.println();	    
	}
    }
   
}
