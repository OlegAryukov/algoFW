package lafore.grafs;

import lafore.grafs.intrface.Edge;

public class TestClientNDG {
    public static void main(String[] args) {
        NonDirectionalGraphImpl<String, String> graph = new NonDirectionalGraphImpl<>();
        Vertex<String, String> a = new Vertex<>("A");
        Vertex<String, String> b = new Vertex<>("B");
        Vertex<String, String> c = new Vertex<>("C");
        Vertex<String, String> d = new Vertex<>("D");
        Vertex<String, String> e = new Vertex<>("E");
        Vertex<String, String> f = new Vertex<>("F");

//        graph.addEdge(a, b);
//        graph.addEdge(a, c);
//        graph.addEdge(a, f);
//        graph.addEdge(c, b);
//        graph.addEdge(c, e);
//        graph.addEdge(c, d);
//        graph.addEdge(d, e);
//        graph.addEdge(d, f);
//
//        for (Edge<String, String> edge : graph.getPathTo(f, b)){
//            System.out.println(edge.getStartVertex().getLabel() + " - " + edge.getEndVertex().getLabel());
//        }
//        graph.dfsEntry(a.getLabel());

        DirectioanalGraphImpl<String, String> graphDir = new DirectioanalGraphImpl<>();
        graphDir.addEdge(a, c);
        graphDir.addEdge(a, f);
        graphDir.addEdge(b, a);
        graphDir.addEdge(b, c);
        graphDir.addEdge(c, d);
        graphDir.addEdge(e, c);
        graphDir.addEdge(d, e);
        graphDir.addEdge(f, d);

        for (Edge<String, String> edge : graphDir.getPathTo(b, f)) {
            System.out.println(edge.getStartVertex().getLabel() + " - " + edge.getEndVertex().getLabel());
        }
    }
}
