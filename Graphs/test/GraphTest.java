
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class GraphTest {
    
    @Test
    public void testGraphCreation() {
        Graph<Integer> graph = prepareGraph();
        
        String expectedResult = "(1 -> 2, 3), (2 -> 1, 5), (3 -> 4), (4 -> 6, 8), (5), (6), (7), (8)";
        
        assertEquals(expectedResult, graph.toString());
    }
 
    @Test
    public void testDepthFirstSearch() {
        Graph<Integer> graph = prepareGraph();
        int[] expectedPath = new int [] { 1, 3, 4, 8 };
                
        ArrayList<Integer> resultPath = graph.dfs(1, 8);
        
        assertArrayEquals(expectedPath, resultPath.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void testBreadthFirstSearch() {
        Graph<Integer> graph = prepareGraph();
        int[] expectedPath = new int [] { 1, 3, 4, 8 };
                
        ArrayList<Integer> resultPath = graph.bfs(1, 8);
        
        assertArrayEquals(expectedPath, resultPath.stream().mapToInt(Integer::intValue).toArray());
    }
    
    private Graph prepareGraph() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 8);
        
        return graph;
    }
    
}
