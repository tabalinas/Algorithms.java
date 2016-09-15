
import java.util.Arrays;


public class MergeSort {
    
    public static void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        
        int middle = (end - start) / 2 + start + 1;
        
        doSort(arr, start, middle - 1);
        doSort(arr, middle, end);
        
        merge(arr, start, middle, end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] leftPart = Arrays.copyOfRange(arr, start, middle);
        int leftIndex = 0;
        int rightIndex = middle;
        int resultIndex = start;
                
        while(leftIndex < leftPart.length && rightIndex <= end) {
            arr[resultIndex++] = (leftPart[leftIndex] > arr[rightIndex])
                    ? arr[rightIndex++] 
                    : leftPart[leftIndex++];
        }
        
        while(leftIndex < leftPart.length) {
            arr[resultIndex++] = leftPart[leftIndex++];
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
