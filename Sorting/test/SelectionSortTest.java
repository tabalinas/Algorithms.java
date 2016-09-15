
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;


public class SelectionSortTest {
    
    @Test
    public void testSelectionSort() {
        int[] array = new int[] { 2, -86, 43, -50, 62, -4, 38, 87, 7, 68 };
        int[] expectedResult = new int[] { -86, -50, -4, 2, 7, 38, 43, 62, 68, 87 };

        SelectionSort.sort(array);

        assertArrayEquals(expectedResult, array);
    }
    
}
