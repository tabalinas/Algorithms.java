
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;


public class ParenthesesTest {

    @Test
    public void testParenthesesGenerate() {
        HashSet<String> expectedResult = new HashSet<>();
        expectedResult.add("((()))");
        expectedResult.add("()()()");
        expectedResult.add("(())()");
        expectedResult.add("()(())");
        expectedResult.add("(()())");
        
        HashSet<String> actualResult = new Parentheses().generate(3);
        
        assertTrue(expectedResult.equals(actualResult));
    }
    
}
