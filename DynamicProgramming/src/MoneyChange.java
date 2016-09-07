
import java.util.Arrays;


public class MoneyChange {

    private int[] coins;
    
    public MoneyChange(int[] coins) {
        this.coins = coins;
    }
    
    public int[] count(int targetSum) {
        if(targetSum <= 0)
            throw new IllegalArgumentException("Wrong target sum");
        
        int[] dp = new int[targetSum + 1];
        int[] pickedCoins = new int[targetSum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int sum = 1; sum <= targetSum; sum++) {
            for(int coin : coins) {
                if(sum < coin)
                    continue;
                
                if(dp[sum - coin] + 1 < dp[sum]) {
                    dp[sum] = dp[sum - coin] + 1;
                    pickedCoins[sum] = coin;
                }
            }
        }
        
        int coinsCount = dp[targetSum];
        
        int[] result = new int[coinsCount];
        
        for (int i = coinsCount - 1, sum = targetSum; i >= 0; sum -= result[i], i--) {
            result[i] = pickedCoins[sum];
        }
        
        return result;
    }
    
}
