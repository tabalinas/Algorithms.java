
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class LinkedListTest {
    
    @Test
    public void testLinkedList() {
       LinkedList<Integer> list = new LinkedList<>(new Integer[] { 1, 2 });
       
       list.add(10);
       list.add(3);
       list.add(4);
       list.add(5);
       
       list.remove(10);
       
       int size = list.size();
       LinkedList.Node<Integer> found = list.find(3);
       
       assertEquals(5, size);
       assertEquals(3, (int)found.value);
       assertEquals("{ 1 -> 2 -> 3 -> 4 -> 5 }", list.toString());  
    }
    
}
