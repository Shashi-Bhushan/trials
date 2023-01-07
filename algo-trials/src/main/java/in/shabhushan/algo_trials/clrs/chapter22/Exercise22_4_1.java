package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

import java.util.LinkedList;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.clrs.chapter22.utii.Logger.log;

public class Exercise22_4_1 {

    private static int time = 0;
    private static LinkedList<AdjListEntry<Character>> topologicalSort;

    public static void main(String[] args) {
        AdjList<Character> graph = new AdjList<>(true);
        graph.addEdge('m','x');
        graph.addEdge('m','q');
        graph.addEdge('m','r');
        graph.addEdge('q','t');
        graph.addEdge('n','q');
        graph.addEdge('n','u');
        graph.addEdge('n','o');
        graph.addEdge('u','t');
        graph.addEdge('r','u');
        graph.addEdge('r','y');
        graph.addEdge('o','r');
        graph.addEdge('o','v');
        graph.addEdge('o','s');
        graph.addEdge('p','o');
        graph.addEdge('p','s');
        graph.addEdge('p','z');
        graph.addEdge('v','w');
        graph.addEdge('v','x');
        graph.addEdge('y','v');
        graph.addEdge('s','r');
        graph.addEdge('w','z');

        for (AdjListEntry<Character> u: graph.getVertices()) {
            u.setColor(Color.WHITE);
            u.setParent(null);
        }

        time = 0;
        topologicalSort = new LinkedList<>();

        for (AdjListEntry<Character> u: graph.getVertices()) {
            if (u.getColor() == Color.WHITE) {
                dfs(graph, u);
            }
        }

        graph.print();

        // Expected : p, n, o, s, m, r, y, v, x, w, z, u, q, t.
        log("Topological Sort Order: " + topologicalSort.stream().map(AdjListEntry::getNode).map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void dfs(AdjList<Character> graph, AdjListEntry<Character> u) {
        time = time + 1;
        u.setStartTime(time);
        u.setColor(Color.GREY);

        for (AdjListEntry<Character> v: graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                v.setParent(u);
                dfs(graph, v);
            }
        }

        time = time + 1;
        u.setColor(Color.BLACK);
        u.setEndTime(time);

        topologicalSort.addFirst(u);
    }
}
