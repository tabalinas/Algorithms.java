
public class ReverseLinkedList {
    
    public static <T> void reverse(LinkedList<T> list) {
        if(list.head == null)
            return;
        
        LinkedList.Node<T> prev = list.head;
        LinkedList.Node<T> current = list.head.next;
        
        while(current != null) {
            LinkedList.Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        list.head.next = null;
        list.head = prev;
    }
    
}
