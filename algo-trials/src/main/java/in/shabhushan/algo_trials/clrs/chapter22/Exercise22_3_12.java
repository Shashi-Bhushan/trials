package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

public class Exercise22_3_12 {

    // todo: add logger

    private static int time;
    private static int cc;

    public static void main(String[] args) {
        log("22.3 Depthfirst search");

        AdjList<Character> graph = new AdjList<>(true);
        graph.addEdge('q', 's');
        graph.addEdge('q', 't');
        graph.addEdge('q', 'w');

        graph.addEdge('w', 's');
        graph.addEdge('s', 'v');
        graph.addEdge('v', 'w');

        graph.addEdge('t', 'x');
        graph.addEdge('t', 'y');
        graph.addEdge('x', 'z');
        graph.addEdge('z', 'x');
        graph.addEdge('y', 'q');
        graph.addEdge('r', 'u');
        graph.addEdge('r', 'y');
        graph.addEdge('u', 'y');

        // Initialize All vertex to Color.WHITE
        for (AdjListEntry<Character> u : graph.getVertices()) {
            u.setColor(Color.WHITE);
            u.setParent(null);
        }

        time = 0;
        cc = 1;

        for (AdjListEntry<Character> u : graph.getVertices()) {
            // for each white vertex, a new connected component has been found
            if (u.getColor() == Color.WHITE) {
                u.setConnectedComponentCount(cc);
                // Increment connected component count now
                cc = cc + 1;
                dfs(graph, u);
            }
        }

        graph.print();
    }

    private static void dfs(AdjList<Character> graph, AdjListEntry<Character> u) {
        time = time + 1;
        u.setStartTime(time);
        u.setColor(Color.GREY);

        for (AdjListEntry<Character> v : graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                v.setParent(u);
                // child's cc count is equal to parent's cc count
                v.setConnectedComponentCount(u.getConnectedComponentCount());
                dfs(graph, v);
            }
        }

        u.setColor(Color.BLACK);
        time = time + 1;
        u.setEndTime(time);
    }

    private static void log(String s) {
        System.out.println(s);
    }
}
