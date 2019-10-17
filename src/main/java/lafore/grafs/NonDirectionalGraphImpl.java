package lafore.grafs;

import lafore.grafs.intrface.Edge;
import lafore.grafs.intrface.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NonDirectionalGraphImpl<T> implements Graph<T> {

    private Map<String, LinkedList<Vertex<T>>> adjacentVertexLists;
    private List<Vertex<T>> vertexesSet;

    public NonDirectionalGraphImpl() {
        adjacentVertexLists = new HashMap<>();
        vertexesSet = new LinkedList<>();
    }

    @Override
    public void addVertex(Vertex<T> vertex) {
        vertexesSet.add(vertex);
    }

    @Override
    public void addEdge(Vertex<T> start, Vertex<T> end) {
        if (!vertexesSet.contains(start)) {
            vertexesSet.add(start);
        }

        if (!vertexesSet.contains(end)) {
            vertexesSet.add(end);
        }

        Edge e = new EdgeImpl(start, end);
        LinkedList<Vertex<T>> adjacentListStart = adjacentVertexLists.get(e.getStartVertex().label);
        if (adjacentListStart != null) {
            if(!adjacentListStart.isEmpty()){
                adjacentListStart.add(start);
            } else {
                adjacentListStart = new LinkedList<>();
                adjacentListStart.add(start);
            }
        }
        LinkedList<Vertex<T>> adjacentListEnd = adjacentVertexLists.get(e.getEndVertex().label);
        if (adjacentListEnd != null) {
            if(!adjacentListEnd.isEmpty()){
                adjacentListEnd.add(start);
            } else {
                adjacentListEnd = new LinkedList<>();
                adjacentListEnd.add(start);
            }
        }
    }

    @Override
    public List<Edge<T>> getPath(Vertex<T> start, Vertex<T> end) {
        return null;
    }
}
