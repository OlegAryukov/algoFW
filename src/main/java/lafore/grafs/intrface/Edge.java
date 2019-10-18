package lafore.grafs.intrface;

import lafore.grafs.Vertex;

public interface Edge<T,D> {
    Vertex<T, D> getStartVertex();
    Vertex<T, D> getEndVertex();
}
