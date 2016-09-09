
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;


public class FloodFillTest {

    @Test
    public void testFloodFill() {
        FloodFill.Image image = new FloodFill.Image(new int[][] { 
            { 1, 1, 1, 1, 0 }, 
            { 0, 1, 0, 0, 1 },
            { 1, 0, 0, 1, 1 },
            { 1, 1, 0, 0, 1 },
            { 1, 1, 1, 1, 1 }
        });
        
        int[][] expectedResult = { 
            { 1, 1, 1, 1, 0 }, 
            { 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1 }
        };
        
        image.fill(2, 3, 1);
        
        assertArrayEquals(expectedResult, image.getBits());
    }
    
}
