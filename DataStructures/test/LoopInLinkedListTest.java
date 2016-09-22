
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class LoopInLinkedListTest {
    
    @Test
    public void testLoopInLinkedList() {
       LinkedList<Integer> list = new LinkedList<>(new Integer[] { 1, 2, 3, 4, 5, 6 });
       
       LinkedList.Node<Integer> second = list.find(2);
       LinkedList.Node<Integer> loop = new LinkedList.Node<>(7);
       loop.next = second;
       list.add(loop);
       
       int actualResult = LoopInLinkedList.find(list);
       
       assertEquals(2, actualResult);
    }
    
}
