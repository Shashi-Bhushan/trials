package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

import static in.shabhushan.algo_trials.clrs.chapter22.utii.Logger.log;

public class Exercise22_4_3 {
    /**
     * Find if the Given graph contains a Cycle
     * Cycle is when the graph has any GREY node.
     */
    public static void main(String[] args) {
        AdjList<Integer> graph = new AdjList<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        log("Graph contains Cycle " + containsCycle(graph));

        graph.addEdge(3, 1);
        log("Graph contains Cycle " + containsCycle(graph));
    }

    private static boolean containsCycle(AdjList<Integer> graph) {
        // initialize vertices
        for (AdjListEntry<Integer> u: graph.getVertices()) {
            u.setColor(Color.WHITE);
            u.setParent(null);
        }

        for (AdjListEntry<Integer> u: graph.getVertices()) {
            if (u.getColor() == Color.WHITE) {
                if (dfs(graph, u)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(AdjList<Integer> graph, AdjListEntry<Integer> u) {
        u.setColor(Color.GREY);

        for (AdjListEntry<Integer> v: graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                v.setParent(u);
            } else if (v.getColor() == Color.GREY) {
                // If found a Grey Node, we've found the ancestor of the current node.
                // Thus, the graph contains a back node i.e. a cycle
                return true;
            }
        }

        return false;
    }

}
