
import java.util.Arrays;


public class QuickSort {
    
    public static void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }
    
    private static void doSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        
        int pivotIndex = getRandom(start, end);
        
        swap(arr, start, pivotIndex);
        
        int index = start;
        
        for(int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[start]) {
                swap(arr, ++index, i);
            }
        }
        
        swap(arr, start, index);
        
        doSort(arr, start, index - 1);
        doSort(arr, index + 1, end);
    }
    
    private static int getRandom(int start, int end) {
        return (int) Math.round((end - start) * Math.random()) + start;
    }
    
    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
