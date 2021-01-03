package in.shabhushan.algo_trials.graph;

import java.util.*;

/**
 * Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
 * Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
 *
 * For printing MST follow the steps -
 * 1. In one line, print an edge which is part of MST in the format -
 * v1 v2 w
 * where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
 *
 *
 * 2. Print V-1 edges in above format in different lines.
 *
 * Note : Order of different edges doesn't matter.
 *
 * Input Format :
 * Line 1: Two Integers V and E (separated by space)
 * Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
 */
public class KruskalAlgorithm {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt();
    int E = sc.nextInt();

    /* Write Your Code Here
     * Complete the Rest of the Program
     * You have to take input and print the output yourself
     */
    Edge[] edge = new Edge[E];

    for (int i = 0; i < E; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();
      int w = sc.nextInt();

      edge[i] = (v1 < v2) ? new Edge(v1, v2, w) : new Edge(v2, v1, w);
    }

    Arrays.sort(edge, (a, b) -> a.weight - b.weight);

    int[] parents = new int[V];

    for (int i = 0; i < V; i++) {
      parents[i] = i;
    }

    int count = 0;

    int e = 0;

    while (count < V - 1) {
      Edge ed = edge[e];

      int p1 = findParent(parents, ed.source);
      int p2 = findParent(parents, ed.dest);

      if (p1 != p2) {
        parents[p1] = p2;

        System.out.println(ed);

        count++;
      }

      e++;
    }
  }

  private static int findParent(int[] parents, int v) {
    int i = v;

    while (parents[i] != i) {
      i = parents[i];
    }

    return i;
  }

  private static class Edge {
    int source;
    int dest;
    int weight;

    public Edge(int source, int dest, int weight) {
      this.source = source;
      this.dest = dest;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return source + " " + dest + " " + weight;
    }
  }
}
