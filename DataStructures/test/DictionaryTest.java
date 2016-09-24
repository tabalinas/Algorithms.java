
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class DictionaryTest {
    
    @Test
    public void testDictionary() {
       Dictionary<Integer, String> dict = new Dictionary<>();
       
       dict.put(1, "value0");
       dict.put(1, "value1");
       dict.put(2, "value2");
       dict.put(3, "value3");
       dict.put(257, "value257"); // key with collision (257 % 256 = 1)
       
       assertEquals("value1", dict.get(1));
       assertEquals("value2", dict.get(2));
       assertEquals("value3", dict.get(3));
       assertEquals("value257", dict.get(257));
    }
    
}
