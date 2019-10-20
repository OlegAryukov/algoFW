package lafore.grafs;

import lafore.grafs.intrface.Edge;
import lafore.grafs.intrface.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DirectioanalGraphImpl<T, D> implements Graph<T, D> {

    private Map<D, LinkedList<D>> adjacentVertexMap;
    private Map<D, Vertex<T, D>> vertexesMap;
    private Map<D, Edge<T, D>> edgeToMap;

    public DirectioanalGraphImpl() {
        adjacentVertexMap = new HashMap<>();
        vertexesMap = new HashMap<>();
        edgeToMap = new HashMap<>();
    }
    @Override
    public void addVertex(Vertex<T, D> vertex) {
        if (adjacentVertexMap.get(vertex.getLabel()) == null) {
            vertexesMap.put(vertex.getLabel(), vertex);
        }
    }

    @Override
    public void addEdge(Vertex<T, D> start, Vertex<T, D> end) {
        if (!vertexesMap.containsKey(start.getLabel())) {
            vertexesMap.put(start.getLabel(), start);
        }

        if (!vertexesMap.containsKey(end.getLabel())) {
            vertexesMap.put(end.getLabel(), end);
        }

        LinkedList<D> adjacentListStart = adjacentVertexMap.get(start.getLabel());
        if (adjacentListStart != null) {
            adjacentListStart.add(end.getLabel());
        } else {
            adjacentListStart = new LinkedList<>();
            adjacentListStart.add(end.getLabel());
            adjacentVertexMap.put(start.getLabel(), adjacentListStart);

        }
//        LinkedList<D> adjacentListEnd = adjacentVertexMap.get(end.getLabel());
//        if (adjacentListEnd != null) {
//
//            adjacentListEnd.add(start.getLabel());
//        } else {
//            adjacentListEnd = new LinkedList<>();
//            adjacentListEnd.add(start.getLabel());
//            adjacentVertexMap.put(end.getLabel(), adjacentListEnd);
//        }
    }

    @Override
    public List<Edge<T, D>> getPathTo(Vertex<T, D> start, Vertex<T, D> end) {
        dfsEntry(start.getLabel());
        LinkedList<Edge<T, D>> pathTo = new LinkedList<>();
        if (!hasPathTo(end.getLabel())) return pathTo;
        for (Vertex i = end; i != start ; i = edgeToMap.get(i.getLabel()).getStartVertex()) {
            pathTo.addFirst(edgeToMap.get(i.getLabel()));
        }

        return pathTo;
    }

    public void dfsEntry(D startLabel) {
        vertexesMap.get(startLabel).setWasVisited(true);
        for (D label : adjacentVertexMap.get(startLabel)) {
            if (!vertexesMap.get(label).isWasVisited()) {
                edgeToMap.put(label, new EdgeImpl<>(vertexesMap.get(startLabel), vertexesMap.get(label)));
                dfsEntry(label);
            }
        }
    }

    private boolean hasPathTo(D label) {
        return vertexesMap.get(label).isWasVisited();
    }
}
