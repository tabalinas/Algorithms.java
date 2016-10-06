
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class ShuffleCardsTest {
    
    @Test
    public void testCardsShuffling() {
        List<Integer> cards = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expectedOrder = Arrays.asList(1, 9, 4, 6, 10, 2, 3, 8, 5, 7);
        long seed = 0;
        
        new ShuffleCards<Integer>(seed).shuffle(cards);
        
        assertArrayEquals(expectedOrder.toArray(), cards.toArray());
    } 
    
}
