
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class BinaryTreeTest {
    
    @Test
    public void testBinaryTreeBuilding() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(12);
        tree.add(17);
        tree.add(-2);
        tree.add(7);
        
        String expectedTreeString = "(10 (5 (-2) (7)) (15 (12) (20 (17))))";
        
        assertEquals(expectedTreeString, tree.toString());
    }
    
    @Test
    public void testRemoveNodeWithoutChildren() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
       
        String expectedTreeString = "(10 (5))";
        
        boolean wasRemoved = tree.remove(15);
        
        assertTrue(wasRemoved);
        assertEquals(expectedTreeString, tree.toString());
    }
    
    @Test
    public void testRemoveNodeWithSingleChild() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(17);
        tree.add(16);
        tree.add(20);
       
        String expectedTreeString = "(10 (5) (17 (16) (20)))";
        
        boolean wasRemoved = tree.remove(15);
        
        assertTrue(wasRemoved);
        assertEquals(expectedTreeString, tree.toString());
    }
    
    @Test
    public void testRemoveNodeWithTwoChildrenAndLeftChildWithoutRightChild() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(12);
        tree.add(17);
        tree.add(16);
        tree.add(25);
        
        String expectedTreeString = "(10 (5) (15 (12) (17 (16) (25))))";
        
        boolean wasRemoved = tree.remove(20);
        
        assertTrue(wasRemoved);
        assertEquals(expectedTreeString, tree.toString());
    }
    
    @Test
    public void testRemoveNodeWithTwoChildrenAndFullSubtreeOnTheLeft() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(12);
        tree.add(30);
        tree.add(25);
        tree.add(35);
        tree.add(27);
        tree.add(20);
        tree.add(29);
        tree.add(28);
        
        String expectedTreeString = "(10 (5) (15 (12) (29 (25 (20) (27 (28))) (35))))";
        
        boolean wasRemoved = tree.remove(30);
        
        assertTrue(wasRemoved);
        assertEquals(expectedTreeString, tree.toString());
    }
    
    @Test
    public void testRemoveRoot() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(12);
        tree.add(17);
        tree.add(-2);
        tree.add(7);
        
        String expectedTreeString = "(7 (5 (-2)) (15 (12) (20 (17))))";
        
        boolean wasRemoved = tree.remove(10);
        
        assertTrue(wasRemoved);
        assertEquals(expectedTreeString, tree.toString());
    }
    
    @Test
    public void testPreOrderTraversal() {
        BinaryTree<Integer> tree = prepareTestTree();
        
        StringBuilder result = new StringBuilder();
        tree.preOrder((BinaryTree.Node<Integer> node) -> {
            result.append(node.value).append(" ");
        });
        
        assertEquals("10 5 -2 7 15 12 20 17 ", result.toString());
    }
    
    @Test
    public void testInOrderTraversal() {
        BinaryTree<Integer> tree = prepareTestTree();
        
        StringBuilder result = new StringBuilder();
        tree.inOrder((BinaryTree.Node<Integer> node) -> {
            result.append(node.value).append(" ");
        });
        
        assertEquals("-2 5 7 10 12 15 17 20 ", result.toString());
    }
    
    @Test
    public void testPostOrderTraversal() {
        BinaryTree<Integer> tree = prepareTestTree();
        
        StringBuilder result = new StringBuilder();
        tree.postOrder((BinaryTree.Node<Integer> node) -> {
            result.append(node.value).append(" ");
        });
        
        assertEquals("-2 7 5 12 17 20 15 10 ", result.toString());
    }

    @Test
    public void testLevelOrderTraversal() {
        BinaryTree<Integer> tree = prepareTestTree();
        
        StringBuilder result = new StringBuilder();
        tree.levelOrder((BinaryTree.Node<Integer> node) -> {
            result.append(node.value).append(" ");
        });
        
        assertEquals("10 5 15 -2 7 12 20 17 ", result.toString());
    }

    private BinaryTree<Integer> prepareTestTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(12);
        tree.add(17);
        tree.add(-2);
        tree.add(7);
        return tree;
    }
}
