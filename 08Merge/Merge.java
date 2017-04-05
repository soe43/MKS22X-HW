import java.util.*;

public class Merge{
    
    public static void mergesort(int[] ary){
       
    }

    public static void mergesortH(int[] ary, int left, int right){
	int middle = (left+right)/2;
	int[] left = new int[middle-left];
	int[] right = new int[right-middle];
	for(int i = 0; i < left.length; i++){
	    left[i] = ary[i];
	}
	for(int k = 0; k < right.length; k++){
	    right[k] = ary[middle+k];
	}
	mergesortH(
    
    //Precondition: Both arrays are sorted
    private static void merge(int[] ary1,int[] ary2, int[] merged){
	int i = 0;
	int k = 0;
	int p = 0;
	while(i < ary1.length && k < ary2.length){
	    if(ary1[i] > ary2[k]){
		merged[p] = ary2[k];
		p++;
		k++;
	    }
	    else if(ary1[i] <= ary2[k]){
		merged[p] = ary1[i];
		p++;
		i++;
	    }
	}
        while(k < ary2.length){
	    merged[p] = ary2[k];
	    p++;
	    k++;
	}
	while(i < ary1.length){
	    merged[p] = ary1[i];
	    p++;
	    i++;
	}
    }

    public static String toString(int[] ary){
	String layout = "";
	for(int i = 0;i < ary.length;i++){
	    layout += ary[i] + " ";
	}
	return layout;
    }
  
    //testing  
    public static void main(String[] args){
	int[] ary1 = new int[10];
	int[] ary2 = new int[10];
	int[] ary3 = new int[20];
	Random r = new Random();
	for(int i = 0; i < 10;i++){
	    ary1[i] = r.nextInt(100);
      	}
	for(int i = 0; i < 10;i++){
	    ary2[i] = r.nextInt(100);
	}
	Arrays.sort(ary1);
	Arrays.sort(ary2);
	merge(ary1,ary2,ary3);
	System.out.println(toString(ary1));	
	System.out.println(toString(ary2));
	System.out.println(toString(ary3));
    }
    	
    
