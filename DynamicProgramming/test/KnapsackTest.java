
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;


public class KnapsackTest {

    @Test
    public void testCount() {
        int[] weights = new int[] { 50, 40, 70, 30, 25 };
        int[] values = new int[] { 15, 10, 40, 25, 30 };
        int capacity = 120;
        
        HashSet<Integer> expectedResult = new HashSet<>();
        expectedResult.add(2);
        expectedResult.add(4);
        
        HashSet<Integer> actualResult = new Knapsack(capacity).pack(weights, values);
        
        assertTrue(expectedResult.equals(actualResult));
    }
    
}
