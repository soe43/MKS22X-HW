import java.util.*;

public class QuickDev {

    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int min, int max) {
        // Base case, partition is of size one or null
        if (min > max) {
            return;
        }

        // Reorder partition so that x < pivot on the left and x >= pivot on the right
        // Returned int is the index of the pivot
        int pivot = partition(array, min, max);

        // Recursively apply quick sort to left and right side of list
        quickSort(array, min, pivot - 1);
        quickSort(array, pivot + 1, max);
    }

    private static int partition(int[] array, int min, int max) {
        int pivot = array[max];
        int left = min;
        int right = max;

        // Repeat until pointers meet
        while (true) {
            // Keep moving left pointer until swap candidate is found
            while (array[left] < pivot) {
                left++;
            }
            // Same for right pointer
            while (array[right] > pivot) {
                right--;
            }

            // If pointers met, we're done on this partition, pivot is on right pointer
            if (left >= right) {
                return right;
            }

            // Swap elements
            swap(array, left, right);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static String toString(int[] data){
	String output = "";
	for(int i = 0;i < data.length;i++){
	    output += data[i]+ " ";
	}
	return output;
    }

    public static void main(String[] args){
	Random r = new Random();
	int[] ary = new int[20];
	for(int i = 0;i < ary.length;i++){
	    ary[i] = r.nextInt()%10;
	}
	System.out.println(toString(ary));
	quickSort(ary,0,ary.length);
	System.out.println(toString(ary));
    }
}
