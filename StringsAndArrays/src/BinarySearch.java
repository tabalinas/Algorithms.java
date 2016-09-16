
public class BinarySearch {

    static int find(int[] arr, int search) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end) {
            int middle = (end - start) / 2 + start;
            
            if(arr[middle] == search) {
                return middle;
            } else if (arr[middle] > search) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        
        return -1;
    }
    
}
