import java.util.*;

public class Quick{

    private static int part(int[]data){
	return part(data,0,data.length);
    }
    
    private static int part(int[] data, int start, int end){
	Random r = new Random();
	int pivot = start + r.nextInt(end - start);
	int pivVal = data[pivot];
	System.out.println(pivot+","+pivVal);
	switchPos(data,pivot,start);
	int left = start + 1;
	int right = end-1;
	int i = left;
	while(left < right){
	    if(data[i] < pivVal){
		left++;
		i++;
	    }
	    else if(data[i] > pivVal){
		switchPos(data,i,right);
		right--;
	    }
	    else{
		i++;
	    }
	}
	if(data[0] < data[1]){
	    return i;
	}
	else{
	switchPos(data,0,right-1);
	if(data[right-1] > data[right]){
	    switchPos(data,right-1,right);
	    return right;
	}else{
	return (right-1);
	}
	}
    }

    private static void switchPos(int[] ary, int position1, int position2){
	int temp = ary[position1];
	ary[position1] = ary[position2];
	ary[position2] = temp;
    }

    public static int quickselect(int[] data, int k){
	return quickselectH(data,k,0,data.length);
    }

    public static int quickselectH(int[] data, int k, int start, int end){
	return 0;
    }

    public static void quickSort(int[] data){
	quickSortH(data,0,data.length);
    }

    private static void quickSortH(int[] data,int start,int end){
	if(start <= end){
	    return;
	}
	int left = start;
	int right = end;
	int i = left;
	while(i <= right){
	    if(data[i] < data[start]){
		switchPos(data,left++,i++);
	    }
	    else if(data[i] > data[start]){
		switchPos(data, i , right--);
	    }
	    else{
		i++;
	    }
	}
	quickSortH(data,start,left-1);
	quickSortH(data,right+1,end);
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

    public static void main(String[]args){
	Random r = new Random();
	int[][] arys = new int[10][8];
	for(int i = 0;i < 10;i++){
	    for(int k = 0;k < 8;k++){
		arys[i][k] = r.nextInt(50);
	    }
	}
	for(int i = 0;i < 10; i++){
	    System.out.println(toString(arys[i]));
	    part(arys[i]);
	    System.out.println(toString(arys[i]));
	    System.out.println("");
	    quickSort(arys[i]);
	    System.out.println(toString(arys[i]));
	}
    }
}
