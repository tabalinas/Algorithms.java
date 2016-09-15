
import java.util.Arrays;


public class MergeSort {
    
    public static void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        
        int middle = (start + end) / 2 + 1;
        
        doSort(arr, start, middle - 1);
        doSort(arr, middle, end);
        
        int[] leftPart = Arrays.copyOfRange(arr, start, middle);
        int left = 0;
        int right = middle;
        int index = start;
                
        while(left < leftPart.length && right <= end) {
            arr[index++] = (leftPart[left] > arr[right]) 
                    ? arr[right++] 
                    : leftPart[left++];
        }
        
        while(left < leftPart.length) {
            arr[index++] = leftPart[left++];
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
