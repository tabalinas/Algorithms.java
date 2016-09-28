
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class GraphTest {
    
    @Test
    public void testGraphCreation() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
     
        String expectedResult = "(1 -> 2, 5), (2 -> 3), (3 -> 4), (4 -> 5), (5), (6)";
        
        assertEquals(expectedResult, graph.toString());
    }
    
}
