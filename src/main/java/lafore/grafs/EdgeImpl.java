package lafore.grafs;

import lafore.grafs.intrface.Edge;

public class EdgeImpl<T> implements Edge<T> {
    private Vertex<T> start;
    private Vertex<T> end;

    public EdgeImpl(Vertex<T> start, Vertex<T> end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Vertex<T> getStartVertex() {
        return start;
    }

    @Override
    public Vertex<T> getEndVertex() {
        return end;
    }
}
