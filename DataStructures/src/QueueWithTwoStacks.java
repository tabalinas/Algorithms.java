
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class QueueWithTwoStacks<T> {

    Stack<T> inbox;
    Stack<T> outbox;
    
    public QueueWithTwoStacks() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }
    
    public void enqueue(T item) {
        inbox.push(item);
    }

    public T dequeue() {
        prepareToDequeue();
        return !outbox.isEmpty() ? outbox.pop() : null;
    }

    public boolean isEmpty() {
        return outbox.isEmpty() && inbox.isEmpty();
    }
    
    private void prepareToDequeue() {
        if(!outbox.isEmpty())
            return;
        
        while(!inbox.isEmpty()) {
            outbox.push(inbox.pop());
        }
    }
    
    @Override
    public String toString() {
        List<T> result = new ArrayList<>(outbox);
        result.addAll(inbox);
        
        return result.toString();
    }
    
}
