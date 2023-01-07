package in.shabhushan.algo_trials.clrs.chapter22.utii;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.clrs.chapter22.utii.Logger.log;

public class AdjList<T extends Comparable<T>> {
    // SortedMap<Vertex, SortedEdges> so that the iteration in AdjList should be alphabetic (or based on Comparator in T)
    private final TreeMap<AdjListEntry<T>, TreeSet<AdjListEntry<T>>> adjList;

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

    public void addVertex(T u) {
        AdjListEntry<T> vertexU = new AdjListEntry<>(u, 0);
        map.put(u, vertexU);
        adjList.put(vertexU, new TreeSet<>());
    }

    public void addEdge(T u, T v, int w) {
        AdjListEntry<T> vertexU = map.getOrDefault(u, new AdjListEntry<>(u, w));
        AdjListEntry<T> vertexV = map.getOrDefault(v, new AdjListEntry<>(v, w));

        TreeSet<AdjListEntry<T>> edges = adjList.getOrDefault(vertexU, new TreeSet<>());
        adjList.put(vertexU, edges);
        edges.add(vertexV);

        edges = adjList.getOrDefault(vertexV, new TreeSet<>());
        adjList.put(vertexV, edges);

        if (!directed) {
            edges.add(vertexU);
        }

        // Put back the vertex in map. Helpful when vertex is created first time
        map.putIfAbsent(u, vertexU);
        map.putIfAbsent(v, vertexV);
    }

    public Set<AdjListEntry<T>> getVertices() {
        return adjList.keySet();
    }

    public AdjListEntry<T> getVertex(T u) {
        return map.get(u);
    }

    public TreeSet<AdjListEntry<T>> getEdges(AdjListEntry<T> u) {
        return adjList.getOrDefault(u, new TreeSet<>());
    }

    public void print() {
        for (Map.Entry<AdjListEntry<T>, TreeSet<AdjListEntry<T>>> entry : adjList.entrySet()) {
            AdjListEntry<T> vertex = entry.getKey();

            log(String.format("Vertex: %2s (%2d, %2d) cc=%2d => Edges: %s", vertex, vertex.getStartTime(),
                    vertex.getEndTime(), vertex.getConnectedComponentCount(),
                    entry.getValue().stream().map(AdjListEntry::getNode).map(String::valueOf).collect(Collectors.joining(", "))));

        }
    }

    public Map<AdjListEntry<T>, TreeSet<AdjListEntry<T>>> getAdjList() {
        return adjList;
    }
}