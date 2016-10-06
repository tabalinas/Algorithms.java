
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ReservoirSamplingTest {
    
    @Test
    public void testReservoirSampling() {
        List<Integer> stream = Arrays.asList(1, 3, -4, 9, 4, -10, 15, 6, 13, -2, 20);
        int amount = 3;
        
        List<Integer> result = ReservoirSampling.getSample(stream.iterator(), amount);
        
        assertEquals(result.size(), 3);
        result.stream().forEach((i) -> {
            assertTrue(stream.contains(i));
        });
        
    }
    
    
}
