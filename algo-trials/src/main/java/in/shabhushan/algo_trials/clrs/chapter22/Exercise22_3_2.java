package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exercise22_3_2 {

    // todo: add logger

    private static int time;

    // Map<Source -> Destination> Edge
    private static List<Map.Entry<Character, Character>> treeEdges = new ArrayList<>();
    private static List<Map.Entry<Character, Character>> forwardOrCrossEdges = new ArrayList<>();
    private static List<Map.Entry<Character, Character>> backEdges = new ArrayList<>();

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
        for (Map.Entry<AdjListEntry<Character>, List<AdjListEntry<Character>>> adjList : graph.getAdjList().entrySet()) {
            AdjListEntry<Character> u = adjList.getKey();

            u.setColor(Color.WHITE);
            u.setParent(null);
        }

        time = 0;
        treeEdges = new ArrayList<>();
        forwardOrCrossEdges = new ArrayList<>();
        backEdges = new ArrayList<>();

        for (Map.Entry<AdjListEntry<Character>, List<AdjListEntry<Character>>> adjList : graph.getAdjList().entrySet()) {
            AdjListEntry<Character> u = adjList.getKey();

            if (u.getColor() == Color.WHITE) {
                dfs(graph, u);
            }
        }

        graph.print();
        System.out.println("Tree Edges " + treeEdges);
        System.out.println("Back Edges " + backEdges);
        System.out.println("Forward/Cross Edges " + forwardOrCrossEdges);
    }

    private static void dfs(AdjList<Character> graph, AdjListEntry<Character> u) {
        time = time + 1;
        u.setStartTime(time);
        u.setColor(Color.GREY);

        for (AdjListEntry<Character> v : graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                treeEdges.add(Map.entry(u.getNode(), v.getNode()));

                v.setParent(u);
                dfs(graph, v);
            } else if (v.getColor() == Color.GREY) {
                backEdges.add(Map.entry(u.getNode(), v.getNode()));
            } else if (v.getColor() == Color.BLACK) {
                forwardOrCrossEdges.add(Map.entry(u.getNode(), v.getNode()));
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
