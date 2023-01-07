package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static in.shabhushan.algo_trials.clrs.chapter22.utii.Logger.log;

public class Exercise22_5 {

    private static int time;

    private static TreeMap<Integer, Character> finishTimeMap;
    private static List<List<AdjListEntry<Character>>> stronglyConnectedComponents;

    /**
     * Find the Strongly Connected Components (SCC) of a Directed Acyclic Graph (DAG)
     */
    public static void main(String[] args) {
        AdjList<Character> graph = new AdjList<>(true);

        // SCC - 1
        graph.addEdge('a', 'b');
        graph.addEdge('b', 'e');
        graph.addEdge('e', 'a');

        graph.addEdge('b', 'c');
        graph.addEdge('b', 'f');
        graph.addEdge('e', 'f');

        // SCC - 2
        graph.addEdge('f', 'g');
        graph.addEdge('g', 'f');

        graph.addEdge('g', 'h');

        // SCC - 3
        graph.addEdge('h', 'h');

        // SCC - 4
        graph.addEdge('c', 'd');
        graph.addEdge('d', 'c');

        graph.addEdge('c', 'g');
        graph.addEdge('d', 'h');

        time = 0;
        init();
        for (AdjListEntry<Character> u: graph.getVertices()) {
            u.setColor(Color.WHITE);
        }

        /*
         * Step 1: Perform DFS, record finish time for each Node
         */
        for (AdjListEntry<Character> u: graph.getVertices()) {
            if (u.getColor() == Color.WHITE) {
                dfs(graph, u);
            }
        }

        /*
         * Step 2: Transpose graph G to graph G^T
         */
        AdjList<Character> graphTransponse = getTransponse(graph);

        /*
         * Step 3: DFS on graphTranspose G^T, in finishing time order
         */
        stronglyConnectedComponents = new ArrayList<>();
        // to get actual object reference of each character in transpose graph
        Map<Character, AdjListEntry<Character>> map = new HashMap<>();
        for (AdjListEntry<Character> u: graphTransponse.getVertices()) {
            u.setColor(Color.WHITE);
            map.put(u.getNode(), u);
        }

        while (!finishTimeMap.isEmpty()) {
            Map.Entry<Integer, Character> highestFinishTime = finishTimeMap.lastEntry();

            List<AdjListEntry<Character>> scc = new ArrayList<>();

            dfsTranspose(graph, graphTransponse, map.get(highestFinishTime.getValue()), scc);

            stronglyConnectedComponents.add(scc);
        }

        log("Strongly Connected Components : " + stronglyConnectedComponents);
    }

    private static void dfsTranspose(AdjList<Character> graph, AdjList<Character> graphTranspose, AdjListEntry<Character> u, List<AdjListEntry<Character>> scc) {
        u.setColor(Color.GREY);
        scc.add(u);

        // remove each entry from finishMap
        removeEntry(graph, u);

        for (AdjListEntry<Character> v: graphTranspose.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                dfsTranspose(graph, graphTranspose, v, scc);
            }
        }

        u.setColor(Color.BLACK);
    }

    private static AdjList<Character> getTransponse(AdjList<Character> graph) {
        AdjList<Character> graphTranspose = new AdjList<>(true);

        for (AdjListEntry<Character> u: graph.getVertices()) {
            for (AdjListEntry<Character> v: graph.getEdges(u)) {
                graphTranspose.addEdge(v.getNode(), u.getNode());
            }
        }

        return graphTranspose;
    }

    private static void init() {
        finishTimeMap = new TreeMap<>();
    }

    private static void dfs(AdjList<Character> graph, AdjListEntry<Character> u) {
        time = time + 1;
        u.setColor(Color.GREY);
        u.setStartTime(time);

        for (AdjListEntry<Character> v: graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                v.setParent(u);
                dfs(graph, v);
            }
        }

        time = time + 1;
        u.setColor(Color.BLACK);
        u.setEndTime(time);

        addEntry(u, time);
    }

    private static void addEntry(AdjListEntry<Character> u, int time) {
        finishTimeMap.put(time, u.getNode());
    }

    /**
     * Remove Entry of vertexU from finishMap
     */
    private static void removeEntry(AdjList<Character> graph, AdjListEntry<Character> u) {
        // get vertex from original graph
        AdjListEntry<Character> vertexU = graph.getVertex(u.getNode());

        // remove from map (as map has unique finish times)
        finishTimeMap.remove(vertexU.getEndTime());
    }
}
