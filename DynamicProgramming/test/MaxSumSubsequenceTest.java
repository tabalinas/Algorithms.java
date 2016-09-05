
import org.junit.Test;
import static org.junit.Assert.*;


public class MaxSumSubsequenceTest {

    @Test
    public void testFind() {
        int[] input = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] expectedResult = new int [] { 4, -1, 2, 1 };
        
        int[] actualResult = new MaxSumSubsequence().find(input);
        
        assertArrayEquals(expectedResult, actualResult);
    }
    
}
