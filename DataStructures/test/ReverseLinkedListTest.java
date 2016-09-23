
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ReverseLinkedListTest {
    
    @Test
    public void testReverseLinkedList() {
       LinkedList<Integer> list = new LinkedList<>(new Integer[] { 1, 2, 3, 4, 5 });
       
       ReverseLinkedList.reverse(list);
       
       assertEquals("{ 5 -> 4 -> 3 -> 2 -> 1 }", list.toString());
    }
    
}
