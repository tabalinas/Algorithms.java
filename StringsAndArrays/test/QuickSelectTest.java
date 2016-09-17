
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class QuickSelectTest {
    
    @Test
    public void testQuickSelect() {
        int[] array = new int[] { 2, -86, 43, -50, 62, -4, 38, 87, 7, 68 };
        int expectedResult = 38;
        
        int actualResult = QuickSelect.find(array, 5);

        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testQuickSelectForTheLastElement() {
        int[] array = new int[] { 2, -86, 43, -50, 62, -4, 38, 87, 7, 68 };
        int expectedResult = 87;
        
        int actualResult = QuickSelect.find(array, array.length - 1);

        assertEquals(expectedResult, actualResult);
    }
    
}
