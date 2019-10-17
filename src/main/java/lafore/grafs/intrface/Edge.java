package lafore.grafs.intrface;

import lafore.grafs.Vertex;

public interface Edge<T> {
    Vertex<T> getStartVertex();
    Vertex<T> getEndVertex();
}
