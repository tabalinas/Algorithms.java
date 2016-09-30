
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class DijkstraSearchTest {
    
    @Test
    public void testGraphCreation() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        
        graph.addEdge(1, 2, 30);
        graph.addEdge(1, 3, 70);
        graph.addEdge(2, 3, 30);
        graph.addEdge(3, 4, 20);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 30);
        graph.addEdge(5, 7, 30);
        graph.addEdge(6, 7, 10);
        
        int[] expectedPath = new int [] { 1, 2, 3, 4, 5, 7 };
        
        ArrayList<Integer> resultPath = new DijkstraSearch(graph).findPath(1, 7);
        
        assertArrayEquals(expectedPath, resultPath.stream().mapToInt(Integer::intValue).toArray());
    }
    
}
