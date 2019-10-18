package lafore.grafs;

import lafore.grafs.intrface.Edge;
import lafore.grafs.intrface.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NonDirectionalGraphImpl<T, D> implements Graph<T, D> {

    private Map<D, LinkedList<D>> adjacentVertexMap;
    private Map<D, Vertex<T, D>> vertexesMap;

    public NonDirectionalGraphImpl() {
        adjacentVertexMap = new HashMap<D, LinkedList<D>>();
        vertexesMap = new HashMap<>();
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
            adjacentListStart = new LinkedList<D>();
            adjacentListStart.add(end.getLabel());
            adjacentVertexMap.put(start.getLabel(), adjacentListStart);

        }
        LinkedList<D> adjacentListEnd = adjacentVertexMap.get(end.getLabel());
        if (adjacentListEnd != null) {

            adjacentListEnd.add(start.getLabel());
        } else {
            adjacentListEnd = new LinkedList<D>();
            adjacentListEnd.add(start.getLabel());
            adjacentVertexMap.put(end.getLabel(), adjacentListEnd);
        }

    }


    @Override
    public List<Edge<T, D>> getPath(Vertex<T, D> start, Vertex<T, D> end) {
        boolean[] isVisited = new boolean[vertexesMap.size()];
        ArrayList<String> pathsList = new ArrayList<>();

        return null;
    }

    public void dfsEntry(D startLable) {
        vertexesMap.get(startLable).setWasVisited(true);
        for (D lable : adjacentVertexMap.get(startLable)) {
            if (!vertexesMap.get(lable).isWasVisited()) dfsEntry(lable);
        }
    }
}
