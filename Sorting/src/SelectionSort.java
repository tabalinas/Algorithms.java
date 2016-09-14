
public class SelectionSort {
    
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
    
}
