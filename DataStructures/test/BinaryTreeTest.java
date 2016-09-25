
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
        tree.add(25);
        tree.add(30);
        
        String expectedTreeString = "(10 (5) (15 (12) (25 (17) (30))))";
        
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
        tree.add(20);
        tree.add(12);
        tree.add(17);
        tree.add(25);
        tree.add(23);
        tree.add(24);
        tree.add(22);
        tree.add(30);
        
        String expectedTreeString = "(10 (5) (15 (12) (22 (17) (25 (23 (24)) (30)))))";
        
        boolean wasRemoved = tree.remove(20);
        
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
        
        String expectedTreeString = "(12 (5 (-2) (7)) (15 (20 (17))))";
        
        boolean wasRemoved = tree.remove(10);
        
        assertTrue(wasRemoved);
        assertEquals(expectedTreeString, tree.toString());
    }
    
}
