
import static org.junit.Assert.*;
import org.junit.Test;


public class QuickSortTest {
    
    @Test
    public void testQuickSort() {
        int[] array = new int[] { 2, -86, 43, -50, 62, -4, 38, 87, 7, 68 };
        int[] expectedResult = new int[] { -86, -50, -4, 2, 7, 38, 43, 62, 68, 87 };

        QuickSort.sort(array);

        assertArrayEquals(expectedResult, array);
    }

}
