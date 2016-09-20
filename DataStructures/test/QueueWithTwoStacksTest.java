
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class QueueWithTwoStacksTest {
    
    @Test
    public void testQueue() {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        
        int firstElement = queue.dequeue();
        
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        int secondElement = queue.dequeue();
        
        assertEquals(1, firstElement);
        assertEquals(2, secondElement);
        assertEquals("[3, 4, 5]", queue.toString());
    }
    
}
