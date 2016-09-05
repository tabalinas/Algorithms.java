
import org.junit.Test;
import static org.junit.Assert.*;


public class LongestIncreasingSubsequenceTest {

    @Test
    public void testFind() {
        int[] input = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        int[] expectedResult = new int [] { 0, 2, 6, 9, 11, 15 };
        
        int[] result = new LongestIncreasingSubsequence().find(input);
        
        assertArrayEquals(expectedResult, result);
    }
    
}
