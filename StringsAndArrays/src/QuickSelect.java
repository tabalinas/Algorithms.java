
public class QuickSelect {

    static int find(int[] arr, int index) {
        return doFind(arr, 0, arr.length - 1, index);
    }

    private static int doFind(int[] arr, int start, int end, int targetIndex) {
        int index = start;
        
        swap(arr, index, targetIndex);
        
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] < arr[start])
                swap(arr, i, ++index);
        }
        
        swap(arr, index, start);
        
        if(index == targetIndex)
            return arr[index];
        else if(index > targetIndex)
            return doFind(arr, start, index - 1, targetIndex);
        else
            return doFind(arr, index + 1, end, targetIndex);
    }
    
    private static void swap(int[] arr, int i1, int i2) {
        int copy = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = copy;
    }
}
