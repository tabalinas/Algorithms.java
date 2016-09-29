
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;


public class Graph<T> {
    
    private HashMap<T, Vertex<T>> vertices;
    
    private HashSet<T> visited;
    private HashMap<T, T> path;
    
    public Graph() {
        vertices = new HashMap<>();
    }
    
    public void addVertex(T value) {
        vertices.put(value, new Vertex(value));
    }
    
    public void addEdge(T from, T to) {
        Vertex<T> vertexFrom = getVertex(from);
        Vertex<T> vertexTo = getVertex(to);
        
        vertexFrom.addEdge(vertexTo);
    }
    
    private Vertex<T> getVertex(T value) {
        if(!vertices.containsKey(value))
            throw new IllegalArgumentException("Non-existing vertex with value " + value);
        
        return vertices.get(value);
    }
   
    @Override
    public String toString() {
        return vertices.values().stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(", "));
    }

    public ArrayList<T> dfs(T start, T end) {
        Vertex<T> startVertex = getVertex(start);
        Vertex<T> endVertex = getVertex(end);
        
        visited = new HashSet<>();
        path = new HashMap<>();
        
        boolean isFound = dfs(startVertex, endVertex);
        
        return isFound ? restorePath(startVertex, endVertex) : null;
    }

    private boolean dfs(Vertex<T> vertex, Vertex<T> endVertex) {
        if(visited.contains(vertex.value))
            return false;
        
        if(vertex == endVertex)
            return true;
        
        visited.add(vertex.value);
        
        for(Edge<T> edge : vertex.edges) {
            path.put(vertex.value, edge.to.value);
            
            boolean isFound = dfs(edge.to, endVertex);
            if(isFound)
                return true;
        }
        
        return false;
    }

    private ArrayList<T> restorePath(Vertex<T> startVertex, Vertex<T> endVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static class Vertex<T> {
        T value;
        ArrayList<Edge<T>> edges;
        
        public Vertex(T value) {
            this.value = value;
            edges = new ArrayList<>();
        }
        
        public void addEdge(Vertex<T> to) {
            addEdge(to, 0);
        }
        
        public void addEdge(Vertex<T> to, int weight) {
            edges.add(new Edge<>(to, weight));
        }
        
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("(").append(value);
            
            if(!edges.isEmpty()) {
                String adjecentStr = edges.stream()
                        .map(e -> e.to.value.toString())
                        .collect(Collectors.joining(", "));
                
                result.append(" -> ").append(adjecentStr);
            }
            
            return result.append(")").toString();
        }
    }
    
    public static class Edge<T> {
        Vertex<T> to;
        int weight;
        
        public Edge(Vertex<T> to) {
            this(to, 0);
        }
        
        public Edge(Vertex<T> to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
