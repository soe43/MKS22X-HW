import java.util.*;
import java.lang.*;
    
public class Partition{

    private static int part(int[] data, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(end - start);
	int pivotValue = data[pivot];
	int temp = 0;
	temp = data[end];
	data[end] = pivotValue;
	data[pivot] = temp;
	pivotValue = temp;
	int position = start;
	for(int i = start;i < end;i++){
	    if(data[i] < pivotValue){
		temp = data[i];
		data[i] = data[position];
		data[position] = temp;
		position++;
	    }
	}
	temp = data[end];
	data[end] = data[position];
	data[position] = temp;
	return position;
    }

    private static String toString(int[] toPrint){
	String layout = "[";
	for(int i = 0; i < toPrint.length;i++){
	    layout += toPrint[i] +", ";
	}
	layout+="]";
	return layout;
    }
		
    public static void main(String[] args){
	int[] ints = {4,12,34,6,1,16,7};
	System.out.println(toString(ints));
	System.out.println(part(ints,0,ints.length - 1));
	System.out.println(toString(ints));
    }
}
	        
		
