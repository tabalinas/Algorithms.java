
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BinarySearchTest {
    
    @Test
    public void testBinarySearch() {
        int[] array = new int[] { -86, -50, -4, 2, 7, 38, 43, 62, 68, 87 };
        int expectedResult = 1;
        
        int actualResult = BinarySearch.find(array, -50);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBinarySearchOfLastItem() {
        int[] array = new int[] { -86, -50, -4, 2, 7, 38, 43, 62, 68, 87 };
        int expectedResult = 9;

        int actualResult = BinarySearch.find(array, 87);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBinarySearchOfNonExistingItem() {
        int[] array = new int[] { -86, -50, -4, 2, 7, 38, 43, 62, 68, 87 };
        int expectedResult = -1;
        
        int actualResult = BinarySearch.find(array, 100);

        assertEquals(expectedResult, actualResult);
    }
    
}
