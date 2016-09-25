
public class BinaryTree<T extends Comparable> {
    
    Node<T> root;

    void add(T value) {
        root = addNode(root, new Node(value));
    }

    private Node<T> addNode(Node<T> parent, Node node) {
        if(parent == null)
            return node;
        
        if(parent.value.compareTo(node.value) < 0) {
            parent.left = addNode(parent.left, node);
        } else {
            parent.right = addNode(parent.right, node);
        }
        
        return parent;
    }

    public boolean remove(T removingValue) {
        return removeNode(root, null, removingValue);
    }

    private boolean removeNode(Node<T> node, Node<T> parent, T removingValue) {
        if(node == null)
            return false;
        
        int compareResult = node.value.compareTo(removingValue);
        
        if(compareResult > 0)
            return removeNode(node.right, node, removingValue);
        
        if(compareResult < 0)
            return removeNode(node.left, node, removingValue);
        
        if(parent == null) {
            root = doRemoveNode(node);
        } else if (parent.left == node) {
            parent.left = doRemoveNode(node);
        } else {
            parent.right = doRemoveNode(node);
        }
        
        return true;
    }
    
    private Node<T> doRemoveNode(Node<T> node) {
        if(node.left == null)
            return node.right;
        
        if(node.right == null)
            return node.left;
        
        if(node.left.right == null) {
            node.left.right = node.right;
            return node.left;
        }
        
        Node<T> parentOfElementToReplaceWith = findParentOfRightMostChild(node.left);
        Node<T> result = parentOfElementToReplaceWith.right;
        
        parentOfElementToReplaceWith.right = result.left;
        result.left = node.left;
        result.right = node.right;
        
        return result;   
    }

    private Node<T> findParentOfRightMostChild(Node<T> node) {
        Node<T> result = node;
        while(result.right.right != null) {
            result = result.right;
        }
        return result;
    }
    
    @Override
    public String toString() {
        return stringify(root);
    }

    private String stringify(Node<T> node) {
        String result = "(" + node.value;
        
        if(node.right != null)
            result += " " + stringify(node.right);
        
        if(node.left != null)
            result += " " + stringify(node.left);
        
        return result + ")";
    }

    
    static class Node<T> {
        public T value;
        Node<T> right;
        Node<T> left;
        
        public Node(T value) {
            this.value = value;
        }
    }
    
}
