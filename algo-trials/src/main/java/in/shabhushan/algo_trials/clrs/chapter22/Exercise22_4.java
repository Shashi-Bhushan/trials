package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Exercise22_4 {
    private static int time;
    private static LinkedList<AdjListEntry<String>> topologicalSort;

    /*
     *
     * Youtube Reference: https://youtu.be/TZDQHplPrNo?t=212
     * Check the running algorithm demonstration
     */
    public static void main(String[] args) {
        log("Exercise 22.4 Topological Sort");

        AdjList<String> graph = new AdjList<>(true);
        graph.addEdge("undershorts", "pants");
        graph.addEdge("undershorts", "shoes");
        graph.addEdge("pants", "belt");
        graph.addEdge("pants", "shoes");
        graph.addEdge("shirt", "belt");
        graph.addEdge("shirt", "tie");
        graph.addEdge("tie", "jacket");
        graph.addEdge("belt", "jacket");
        graph.addEdge("socks", "shoes");
        // this one is without any outgoing/incoming edges
        graph.addVertex("watch");

        // Initialize All vertex to Color.WHITE
        for (AdjListEntry<String> u : graph.getVertices()) {
            u.setColor(Color.WHITE);
            u.setParent(null);
        }

        time = 0;
        topologicalSort = new LinkedList<>();

        for (AdjListEntry<String> u : graph.getVertices()) {
            // for each white vertex, a new connected component has been found
            if (u.getColor() == Color.WHITE) {
                dfs(graph, u);
            }
        }

//        dfs(graph, graph.getVertex("shirt"));
//        dfs(graph, graph.getVertex("watch"));
//        dfs(graph, graph.getVertex("undershorts"));
//        dfs(graph, graph.getVertex("socks"));

        log("Topological Sort Order: " + topologicalSort.stream().map(AdjListEntry::getNode).collect(Collectors.joining(", ")));
    }

    private static void dfs(AdjList<String> graph, AdjListEntry<String> u) {
        time = time + 1;
        u.setStartTime(time);
        u.setColor(Color.GREY);

        for (AdjListEntry<String> v : graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                v.setParent(u);
                dfs(graph, v);
            }
        }

        u.setColor(Color.BLACK);
        time = time + 1;
        u.setEndTime(time);

        // After adding the finish time, add the vertexU to topological Sort
        topologicalSort.addFirst(u);
    }

    private static void log(String s) {
        System.out.println(s);
    }
}
