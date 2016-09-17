
public class RotatedBinarySearch {

    static int find(int[] arr, int search) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end) {
            int middle = (end - start) / 2 + start;
            
            if(arr[middle] == search)
                return middle;
            
            if (arr[middle] > search) {
                if(arr[start] > search) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                if(arr[end] < search) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        
        return -1;
    }
    
}
