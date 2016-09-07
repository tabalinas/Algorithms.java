
import org.junit.Test;
import static org.junit.Assert.*;


public class MoneyChangeTest {

    @Test
    public void testCount() {
        int[] coins = new int[] { 1, 3, 5 };
        int targetSum = 11;
        int[] expectedResult = new int [] { 5, 5, 1 };
        
        int[] actualResult = new MoneyChange(coins).count(targetSum);
        
        assertArrayEquals(expectedResult, actualResult);
    }
    
}
