
public class LinkedList<T> {
    
    private Node<T> head;
    
    public LinkedList() { }
    
    public LinkedList(T[] items) {
        for(T item : items) {
            add(item);
        }
    }
    
    public void add(T value) {
        add(new Node<>(value));
    }
    
    public void add(Node<T> node) {
        if(head == null) {
            head = node;
            return;
        }
        
        Node<T> current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = node;
    }
    
    public boolean remove(T value) {
        if(head == null)
            return false;
        
        if(head.value == value) {
            head = head.next;
            return true;
        }
        
        Node<T> current = head;
        while(current.next != null) {
            if(current.next.value == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    public Node<T> find(T value) {
        Node<T> current = head;
        while(current != null) {
            if(current.value == value) {
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    public int size() {
        if(head == null)
            return 0;
        
        int result = 1;
        
        Node<T> current = head;
        while(current.next != null) {
            current = current.next;
            result++;
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{ ");
        
        if(head != null) {
            result.append(head.value.toString());
        }
        
        Node<T> current = head.next;
        while(current != null) {
            result.append(" -> ").append(current.value.toString());
            current = current.next;
        }
        
        result.append(" }");
        
        return result.toString();
    }
    
    public static class Node<T> {
        Node next;
        T value;
        
        public Node(T value) {
            this.value = value;
        }
    }
}
