
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class DijkstraSearch<T> {
    
    Graph<T> graph;
    
    public DijkstraSearch(Graph<T> graph) {
        this.graph = graph;
    }

    public ArrayList<T> findPath(T start, T end) {
        Graph.Vertex<T> startVertex = graph.getVertex(start);
        Graph.Vertex<T> endVertex = graph.getVertex(end);
        
        HashSet<T> visited = new HashSet<>();
        HashMap<T, T> path = new HashMap<>();
        HashMap<T, Integer> distances = new HashMap<>();
        
        PriorityQueue<Graph.Vertex<T>> queue = new PriorityQueue<>(new Comparator<Graph.Vertex<T>>() {
            @Override
            public int compare(Graph.Vertex<T> v1, Graph.Vertex<T> v2) {
                int weight1 = distances.containsKey(v1.value) ? distances.get(v1.value) : Integer.MAX_VALUE;
                int weight2 = distances.containsKey(v2.value) ? distances.get(v2.value) : Integer.MAX_VALUE;
                return weight1 - weight2;
            }
        });
        
        queue.add(startVertex);
        distances.put(start, 0);
        
        while(!queue.isEmpty()) {
            
            Graph.Vertex<T> current = queue.poll();
            
            if(current == endVertex)
                return restorePath(startVertex, endVertex, path);
            
            visited.add(current.value);
            
            for(Graph.Edge<T> edge : current.edges) {
                if(visited.contains(edge.to.value))
                    continue;
                
                int distanceToVertex = getDistance(distances, edge.to.value);
                int suggestedDistance = getDistance(distances, current.value) + edge.weight;
                
                if(distanceToVertex > suggestedDistance) {
                    distances.put(edge.to.value, suggestedDistance);
                    path.put(edge.to.value, current.value);
                }
                
                queue.add(edge.to);
            }
        }
        
        return null;
    }

    private int getDistance(HashMap<T, Integer> distances, T value) {
        return distances.containsKey(value) ? distances.get(value) : Integer.MAX_VALUE;
    }
    
    private ArrayList<T> restorePath(Graph.Vertex<T> startVertex, Graph.Vertex<T> endVertex, HashMap<T, T> path) {
        ArrayList<T> result = new ArrayList<>();
        
        T current = endVertex.value;
        
        while(current != startVertex.value) {
            result.add(0, current);
            current = path.get(current);
        }
        
        result.add(0, startVertex.value);
        
        return result;
    }

}
