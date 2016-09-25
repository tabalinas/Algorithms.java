
import java.util.Queue;
import java.util.LinkedList;


public class BinaryTree<T extends Comparable> {
    
    Node<T> root;

    void add(T value) {
        root = addNode(root, new Node(value));
    }

    private Node<T> addNode(Node<T> parent, Node node) {
        if(parent == null)
            return node;
        
        if(parent.value.compareTo(node.value) > 0) {
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
            return removeNode(node.left, node, removingValue);
        
        if(compareResult < 0)
            return removeNode(node.right, node, removingValue);
        
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
    
    public void preOrder(NodeVisitor<T> nodeVisitor) {
        doPreOrder(root, nodeVisitor);
    }
    
    private void doPreOrder(Node<T> node, NodeVisitor<T> nodeVisitor) {
        if(node == null)
            return;
        
        nodeVisitor.visit(node);
        
        doPreOrder(node.left, nodeVisitor);
        doPreOrder(node.right, nodeVisitor);
    }
    
    public void inOrder(NodeVisitor<T> nodeVisitor) {
        doInOrder(root, nodeVisitor);
    }
    
    private void doInOrder(Node<T> node, NodeVisitor<T> nodeVisitor) {
        if(node == null)
            return;
        
        
        doInOrder(node.left, nodeVisitor);
        nodeVisitor.visit(node);
        doInOrder(node.right, nodeVisitor);
    }
    
    public void postOrder(NodeVisitor<T> nodeVisitor) {
        doPostOrder(root, nodeVisitor);
    }
    
    private void doPostOrder(Node<T> node, NodeVisitor<T> nodeVisitor) {
        if(node == null)
            return;
        
        doPostOrder(node.left, nodeVisitor);
        doPostOrder(node.right, nodeVisitor);
        nodeVisitor.visit(node);
    }
    
    @Override
    public String toString() {
        return stringify(root);
    }

    private String stringify(Node<T> node) {
        String result = "(" + node.value;
        
        if(node.left != null)
            result += " " + stringify(node.left);
        
        if(node.right != null)
            result += " " + stringify(node.right);
        
        return result + ")";
    }

    void levelOrder(NodeVisitor<T> nodeVisitor) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            Node<T> node = queue.poll();
            
            nodeVisitor.visit(node);
           
            if(node.left != null)
                queue.offer(node.left);
            
            if(node.right != null)
                queue.offer(node.right);
        }
    }
    
    
    static interface NodeVisitor<T> {
        void visit(Node<T> node);
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
