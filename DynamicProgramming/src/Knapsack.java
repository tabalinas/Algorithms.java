
import java.util.Arrays;
import java.util.HashSet;


public class Knapsack {

    private final int capacity;
    
    public Knapsack(int capacity) {
        this.capacity = capacity;
    }
    
    public HashSet<Integer> pack(int[] weights, int[] values) {
        if(weights == null || values == null || weights.length == 0 || weights.length != values.length)
            throw new IllegalArgumentException("Wrong arguments: values and weights should be non-empty arrays with equal length");
        
        int[] dp = new int[capacity + 1];
        int[] packedItems = new int[capacity + 1];
        
        for(int w = 1; w <= capacity; w++) {
            dp[w] = dp[w - 1];
            packedItems[w] = packedItems[w - 1];
            
            for(int i = 0; i < weights.length; i++) {
                if(w < weights[i])
                    continue;
                
                int suggestedValue = dp[w - weights[i]] + values[i];
                if(dp[w] < suggestedValue && !itemIsAlreadyPacked(i, w, packedItems, weights)) {
                    dp[w] = suggestedValue;
                    packedItems[w] = i;
                }
            }
        }
        
        HashSet<Integer> result = new HashSet<>();
        
        for(int w = capacity; w > 0;) {
            int packedItem = packedItems[w];
            result.add(packedItem);
            w -= weights[packedItem];
        }
        
        return result;
    }

    private boolean itemIsAlreadyPacked(int itemIndex, int weight, int[] packedItems, int[] weights) {
        int packedIndex = itemIndex;
        
        for(int w = weight - weights[packedIndex]; w > 0; w -= weights[packedIndex]) {
            if(packedItems[w] == itemIndex)
                return true;
            packedIndex = packedItems[w];
        }
        
        return false;
    }
    
}
