package lafore.grafs;

import lafore.grafs.intrface.Edge;
import lafore.grafs.intrface.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NonDirectionalGraphImpl<T> implements Graph<T> {

    private Map<String, LinkedList<String>> adjacentVertexMap;
    private Map<String, Vertex<T>> vertexesMap;
    private boolean marked[] = null;

    public NonDirectionalGraphImpl() {
        adjacentVertexMap = new HashMap<String, LinkedList<String>>();
        vertexesMap = new HashMap<>();
    }

    @Override
    public void addVertex(Vertex<T> vertex) {
        if(adjacentVertexMap.get(vertex.getLabel())==null){
            vertexesMap.put(vertex.getLabel(), vertex);
        }
    }

    @Override
    public void addEdge(Vertex<T> start, Vertex<T> end) {
        if (!vertexesMap.containsKey(start.getLabel())) {
            vertexesMap.put(start.getLabel(), start);
        }

        if (!vertexesMap.containsKey(end.getLabel())) {
            vertexesMap.put(end.getLabel(), end);
        }

        LinkedList<String> adjacentListStart = adjacentVertexMap.get(start.getLabel());
        if (adjacentListStart != null) {
            if(!adjacentListStart.isEmpty()){
                adjacentListStart.add(end.getLabel());
            } else {
                adjacentListStart = new LinkedList<>();
                adjacentListStart.add(end.getLabel());
            }
        }
        LinkedList<String> adjacentListEnd = adjacentVertexMap.get(end.getLabel());
        if (adjacentListEnd != null) {
            if(!adjacentListEnd.isEmpty()){
                adjacentListEnd.add(start.getLabel());
            } else {
                adjacentListEnd = new LinkedList<>();
                adjacentListEnd.add(start.getLabel());
            }
        }
    }

    @Override
    public List<Edge<T>> getPath(Vertex<T> start, Vertex<T> end) {
        boolean[] isVisited = new boolean[vertexesMap.size()];
        ArrayList<String> pathsList = new ArrayList<>();

        return null;
    }

    private void dfsEntry(String startLable){
        vertexesMap.get(startLable).setWasVisited(true);
        for (String lable: adjacentVertexMap.get(startLable)){
            if(!vertexesMap.get(lable).isWasVisited()) dfsEntry(lable);
        }
    }
}
