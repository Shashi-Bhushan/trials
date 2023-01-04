package in.shabhushan.algo_trials.clrs.chapter22.utii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdjList<T extends Comparable<T>> {
    private final TreeMap<AdjListEntry<T>, List<AdjListEntry<T>>> adjList;
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

        map.put(u, vertexU);
        map.put(v, vertexV);
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