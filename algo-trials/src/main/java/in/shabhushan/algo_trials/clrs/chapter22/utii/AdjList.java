package in.shabhushan.algo_trials.clrs.chapter22.utii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdjList<T extends Comparable<T>> {
    // Sorted Map so that the iteration in AdjList should be alphabetic (or based on Comparator in T)
    private final TreeMap<AdjListEntry<T>, List<AdjListEntry<T>>> adjList;

    // Map<T -> Vertex T>
    // required because the addEdge method takes only T. We need singleton values for each T in Adj List i.e. there should be only one vertex corresponding to T in Adj List
    private final Map<T, AdjListEntry<T>> map;

    private final boolean directed;

    public AdjList(boolean directed) {
        this.directed = directed;
        adjList = new TreeMap<>();
        map = new HashMap<>();
    }

    public void addEdge(T u, T v) {
        this.addEdge(u, v, 0);
    }

    public void addEdge(T u, T v, int w) {
        AdjListEntry<T> vertexU = map.getOrDefault(u, new AdjListEntry<>(u, w));
        AdjListEntry<T> vertexV = map.getOrDefault(v, new AdjListEntry<>(v, w));

        List<AdjListEntry<T>> edges = adjList.getOrDefault(vertexU, new ArrayList<>());
        edges.add(vertexV);

        adjList.put(vertexU, edges);

        if (!directed) {
            edges = adjList.getOrDefault(vertexV, new ArrayList<>());
            edges.add(vertexU);
            adjList.put(vertexV, edges);
        }

        // Put back the vertex in map. Helpful when vertex is created first time
        map.putIfAbsent(u, vertexU);
        map.putIfAbsent(v, vertexV);
    }

    public List<AdjListEntry<T>> getEdges(AdjListEntry<T> u) {
        return adjList.getOrDefault(u, new ArrayList<>());
    }

    public void print() {
        for (Map.Entry<AdjListEntry<T>, List<AdjListEntry<T>>> entry : adjList.entrySet()) {
            AdjListEntry<T> vertex = entry.getKey();
            System.out.printf("Vertex: %s (%d, %d) ", vertex, vertex.getStartTime(), vertex.getEndTime());

            for (AdjListEntry edge : entry.getValue()) {
                System.out.print(edge.getNode() + ", ");
            }
            System.out.println();
        }
    }

    public Map<AdjListEntry<T>, List<AdjListEntry<T>>> getAdjList() {
        return adjList;
    }
}