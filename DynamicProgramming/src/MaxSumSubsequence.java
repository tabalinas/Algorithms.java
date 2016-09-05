
import java.util.Arrays;


public class MaxSumSubsequence {

    public MaxSumSubsequence() {}
    
    public int[] find(int[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("Input array is empty");
        
        int sum = arr[0];
        int maxSum = sum;
        int maxStartIndex = 0;
        int maxEndIndex = maxStartIndex;
        
        for (int i = 1; i < arr.length; i++) {
            if(sum + arr[i] >= arr[i]) {
                sum += arr[i];
                if(sum > maxSum) {
                    maxSum = sum;
                    maxEndIndex = i;
                }
            } else {
                sum = arr[i];
                maxSum = sum;
                maxStartIndex = i;
                maxEndIndex = maxStartIndex;
            }
        }
        
        return Arrays.copyOfRange(arr, maxStartIndex, maxEndIndex + 1);
    }
    
}
