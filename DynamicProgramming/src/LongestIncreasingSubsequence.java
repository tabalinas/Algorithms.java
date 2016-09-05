
public class LongestIncreasingSubsequence {

    private int[] input;
    
    public LongestIncreasingSubsequence() {}
    
    public int[] find(int[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("Input array is empty");
        
        input = arr;
        
        int[] dp = computeDp();
        int[] result = findSequence(dp);
        
        return result;
    }
    
    private int[] computeDp() {
        int[] result = new int[input.length];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if(input[i] >= input[j] && result[i] < result[j] + 1) {
                    result[i] = result[j] + 1;
                }
            }
        }
        
        return result;
    }

    private int[] findSequence(int[] dp) {
        int maxLengthIndex = getMaxLengthIndex(dp);
        int resultLength = dp[maxLengthIndex];
        
        int[] result = new int[resultLength];
        
        for (int i = resultLength - 1, itemIndex = maxLengthIndex; i >= 0 && itemIndex > -1; i--) {
            result[i] = input[itemIndex];
            itemIndex = getNextIndex(dp, itemIndex);
        }
        
        return result;
    }
    
    private int getMaxLengthIndex(int[] dp) {
        int result = dp.length - 1;
        
        for (int i = dp.length - 2; i > 0; i--) {
            result = (dp[i] > dp[result]) ? i : result;
        }
        
        return result;
    }
    
    private int getNextIndex(int[] dp, int itemIndex) {
        int fromLength = dp[itemIndex];
        
        for (int i = itemIndex; i >= 0; i--) {
            if(dp[i] == fromLength - 1)
                return i;
        }
        
        return -1;
    }
}
