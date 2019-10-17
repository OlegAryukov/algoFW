package lafore.grafs.intrface;

import lafore.grafs.Vertex;

import java.util.List;

public interface Graph<T> {
    void addVertex(Vertex<T> vertex);
    void addEdge(Vertex<T> start, Vertex<T> end);
    List<Edge<T>> getPath(Vertex<T> start, Vertex<T> end);
}
