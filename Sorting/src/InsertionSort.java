
public class InsertionSort {
    
    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
