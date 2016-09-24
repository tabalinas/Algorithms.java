
import java.lang.reflect.Array;


public class Dictionary<K, V> {
    
    private final int CAPACITY = 256;
    
    Node<K,V>[] values;
    
    public Dictionary() {
        values = (Node<K,V>[])Array.newInstance(Node.class, CAPACITY);
    }
    
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = values[index];
        
        if(node == null) {
            values[index] = createNode(key, value);
            return;
        }
        
        while(node != null && !node.key.equals(key)) {
            node = node.next;
        }
        
        if(node != null) {
            node.value = value;
            return;
        }
        
        node = createNode(key, value);
        node.next = values[index];
        values[index] = node;
    }
    
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = values[index];
        
        if(node == null)
            return null;
        
        while(node != null && !node.key.equals(key)) {
            node = node.next;
        }
        
        return (node != null) ? node.value : null;
    }
    
    private Node<K, V> createNode(K key, V value) {
        return new Node<K, V>(key, value);
    }

    private int getIndex(K key) {
        return key.hashCode() % CAPACITY;
    }
    
    
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
            
}
