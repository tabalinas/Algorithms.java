
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class RotatedBinarySearchTest {
    
    @Test
    public void testBinarySearchInRotatedArray() {
        int[] array = new int[] { 7, 38, 43, 62, 68, 87, -86, -50, -4, 2 };
        int expectedResult = 7;
        
        int actualResult = RotatedBinarySearch.find(array, -50);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBinarySearchOfLastItemInRotated() {
        int[] array = new int[] { 2, 7, 38, 43, 62, 68, 87, -86, -50, -4 };
        int expectedResult = 9;

        int actualResult = RotatedBinarySearch.find(array, -4);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBinarySearchInRotatedArrayWithRotationLongerThanHalf() {
        int[] array = new int[] { 62, 68, 87, -86, -50, -4, 2, 7, 38, 43 };
        int expectedResult = 1;
        
        int actualResult = RotatedBinarySearch.find(array, 68);

        assertEquals(expectedResult, actualResult);
    }
    
}
