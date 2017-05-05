import java.util.*;

public class Merge{
    
    public static void mergesort(int[] ary){
	mergesortH(ary,0,ary.length-1);
    }
    
    public static void mergesortH(int[] ary, int left, int right){
	if(ary.length > 1){
	    int m = ary.length/2;
	    int[] first = new int[m];
	    int[] second = new int[ary.length-m];
	    int c1 = 0;
	    for(int i = 0;i < m;i++){
		first[c1] = ary[i];
		c1++;
	    }
	    int c2 = 0;
	    for(int i = m;i<ary.length;i++){
		second[c2] = ary[i];
		c2++;
	    }
	    
	    mergesortH(first,left,m);
	    mergesortH(second,m+1,right);

	    merge(first,second,ary);
	}
    }
    
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
    /*
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
	System.out.println(toString(ary1));	
	System.out.println(toString(ary2));
	mergesort(ary1);
	mergesort(ary2);
	merge(ary1,ary2,ary3);
	System.out.println(toString(ary1));	
	System.out.println(toString(ary2));
	System.out.println(toString(ary3));
    }
    */
}
    	
    
