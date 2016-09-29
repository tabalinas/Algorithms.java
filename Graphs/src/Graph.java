
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


public class Graph<T> {
    
    ArrayList<Vertex<T>> vertices;
    
    public Graph() {
        vertices = new ArrayList<>();
    }
    
    public void addVertex(T value) {
        vertices.add(new Vertex(value));
    }
    
    public void addEdge(T from, T to) {
        Vertex<T> vertexFrom = getVertex(from);
        Vertex<T> vertexTo = getVertex(to);
        
        vertexFrom.addEdge(vertexTo);
    }
    
    private Vertex<T> getVertex(T value) {
        Optional<Vertex<T>> result = vertices.stream().filter(x -> x.value == value).findFirst();
        
        if(!result.isPresent())
            throw new IllegalArgumentException("Non-existing vertex with value " + value);
        
        return result.get();
    }
   
    @Override
    public String toString() {
        return vertices.stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(", "));
    }

    public ArrayList<T> dfs(T start, T end) {
        Vertex<T> startVertex = getVertex(start);
        return dfs(startVertex, end, new ArrayList<>());
    }

    private ArrayList<T> dfs(Vertex<T> vertex, T end, ArrayList<T> path) {
        path.add(vertex.value);
        
        if(vertex.value.equals(end))
            return path;
        
        for(Edge<T> edge : vertex.edges) {
            ArrayList<T> result = dfs(edge.to, end, (ArrayList<T>) path.clone());
            if(result != null)
                return result;
        }
        
        return null;
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
