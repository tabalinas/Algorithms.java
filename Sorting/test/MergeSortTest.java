
import static org.junit.Assert.*;
import org.junit.Test;


public class MergeSortTest {
    
    @Test
    public void testMergeSort() {
        int[] array = new int[] { 2, -86, 43, -50, 62, -4, 38, 87, 7, 68 };
        int[] expectedResult = new int[] { -86, -50, -4, 2, 7, 38, 43, 62, 68, 87 };

        MergeSort.sort(array);

        assertArrayEquals(expectedResult, array);
    }

}
