
import java.util.Arrays;


public class HeapSort {
    
    public static void sort(int[] arr) {
        buildMaxHeap(arr);
        
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for(int i = arr.length / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
    }

    private static void siftDown(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIndex = index;
        
        if(left < heapSize && arr[index] < arr[left]) {
            maxIndex = left;
        }
        
        if(right < heapSize && arr[maxIndex] < arr[right]) {
            maxIndex = right;
        }
        
        if(index != maxIndex) {
            swap(arr, index, maxIndex);
            siftDown(arr, maxIndex, heapSize);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
