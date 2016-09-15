
public class BubbleSort {
    
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            
            for(int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[j - 1]) {
                    swapped = true;
                    swap(arr, j, j - 1);
                }
            }
            
            if(!swapped)
                break;
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
