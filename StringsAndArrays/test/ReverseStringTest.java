
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ReverseStringTest {
    
    @Test
    public void testReverseStringWithEvenCharacters() {
        String input = "asdfghjk";
        String expectedResult = "kjhgfdsa";
        
        String actualResult = StringReverser.reverse(input);

        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testReverseStringWithOddCharacters() {
        String input = "asdfghjkl";
        String expectedResult = "lkjhgfdsa";
        
        String actualResult = StringReverser.reverse(input);

        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testReverseSingleCharacter() {
        String input = "a";
        String expectedResult = "a";
        
        String actualResult = StringReverser.reverse(input);

        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testReverseEmptyString() {
        String input = "";
        String expectedResult = "";
        
        String actualResult = StringReverser.reverse(input);

        assertEquals(expectedResult, actualResult);
    }
    
}
