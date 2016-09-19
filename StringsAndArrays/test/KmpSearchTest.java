
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class KmpSearchTest {
    
    @Test
    public void testKmpSearch() {
        String txt = "ababdbaababa";
        String pattern = "ababa";
        int expectedResult = 7;
        
        int actualResult = KmpSearch.pos(pattern, txt);

        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testKmpSearchForNotFoundPattern() {
        String txt = "ababdbaababa";
        String pattern = "ababac";
        int expectedResult = -1;
        
        int actualResult = KmpSearch.pos(pattern, txt);

        assertEquals(expectedResult, actualResult);
    }
    
}
