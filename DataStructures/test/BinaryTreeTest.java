
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
    
}
