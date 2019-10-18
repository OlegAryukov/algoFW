package lafore.grafs;

public class TestClientNDG {
    public static void main(String[] args) {
        NonDirectionalGraphImpl<String, String> graph = new NonDirectionalGraphImpl<>();
        Vertex<String, String> a = new Vertex<>("A");
        Vertex<String, String> b = new Vertex<>("B");
        Vertex<String, String> c = new Vertex<>("C");
        Vertex<String, String> d = new Vertex<>("D");
        Vertex<String, String> e = new Vertex<>("E");
        Vertex<String, String> f = new Vertex<>("F");

        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(a, f);
        graph.addEdge(c, b);
        graph.addEdge(c, e);
        graph.addEdge(c, d);
        graph.addEdge(d, e);
        graph.addEdge(d, f);

        graph.dfsEntry(a.getLabel());
    }
}
