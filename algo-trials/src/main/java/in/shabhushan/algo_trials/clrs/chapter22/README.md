### Graph Representation

* If G is a directed graph, sum of length of all the adjacency lists = |E|. If G is an undirected graph, sum of length
  of all the adjacency lists = 2|E|.

* For both directed and undirected graphs, the adjacency-list representation has the desirable property that the amount
  of memory it requires = O(V + E).

### Breadth-First Search

* Prim's algorithm and Dijkstra's algorithm use similar idea.

* BFS computes the **shortest distance** from the source node to every other reachable node, in **an undirected unweighted**
  **graph**. It can find shortest path in **cyclic graphs**, but we need to keep track of queued nodes in addition to
  visited nodes.

* For any vertex 􏰁v reachable from s, the simple path in the breadth-first tree from s to v􏰁 corresponds to a
  “shortest path” from s to v􏰁 in G, that is, a path containing the smallest number of edges.

* The algorithm discovers all vertices at distance k from s before discovering any vertices at distance k + 1.

* The shortest path from node s to v can be obtaining by traversing the parent array from node v back to s.

* Total running time = **O(V + E)**.

### Depth-First Search

* In contrast to BFS, DFS algorithm runs on multiple source nodes. Hence, the result is not a DFS
  tree but a DFS forest.

* Total running time = **O(V + E)**.

* Following properties hold in a DFS tree
    - [u.start, u.finish] and [v.start, v.finish] are completely disjoint and neither u nor v are descendants of each
      other in the tree.
    - v.start < u.start < u.finish < v.finish implies that u is a descendant of v.

* Classification of edges
    - **Tree edges** are the edges of the DFS tree. Edge (u, v) is a tree edge if v was discovered using this edge.
    - If u is a descendant of v in the DFS tree and there is an edge (u,v) in the graph, this edge is called a **back**
      **edge**.
    - **Forward edges** are non tree edges (u,v) that connect ancestor u to descendant v.
    - **Cross edges** are all other edges, i.e. edges between two vertices in same DFS tree which are not in an
      ancestor-descenant relationship, as well as edges between different DFS trees.

* DFS of an undirected graph only yields tree edges and forward edges.

* A directed graph is acyclic only if a DFS does not yield any back edges.

### Topological Sort

* Only possible for acyclic graphs.

* Topological sorting can be achieved by first performing a DFS on the graph and then sorting the nodes according to
  their finish time. The source node (assuming there is only one) will have the **highest finish time**.

* Total running time = **O(V + E)**.

### Strongly Connected Components (directed graphs)

* In an SCC, every vertex v is reachable from every other vertex v.

* A graph G and its reverse G<sup>R</sup> have the same SCC. G<sup>R</sup> is obtained by reversing every edge in G

* Total running time = **O(V + E)**.

* [Youtube Reference](https://youtu.be/TZDQHplPrNo?t=774) 

### Minimum Spanning Tree

* MST algorithms are greedy algorithms and they use the cut property to build the MST.

* Cut property: Let A be a subset of E included in a MST. Then let (S, V-S) be the cut containing A. If (u,v) is the
  lightest edge crossing the cut, then adding {(u, v)} U A will also be a subset of some MST.

#### Kruskal's algorithm

* Running time depends on how the disjoint set data structure is implemented. If it is implemented using
  union-by-rank and path compression techniques, then total running time = O(ElogE + ElogV).

* Since E = O(V<sup>2</sup>), log E = O(log V). So running time can be simplified to **O(ElogV)**.

* Works with negative weights also.

#### Prim's algorithm

* Works with negative weights.

* Total running time = **O((V + E)logV)**.

### Single Source Shortest Path

* Shortest path between u and v contains other shortest paths within it.

* If graph contains a negative weight cycle reachable from s, then shortest paths are not well defined.

* Shortest paths have **no cycles**. Since it is acyclic, SP contains V vertices and V-1 edges.

* Shortest paths are not necessarily unique, and neither are shortest-paths trees.

#### Bellman-Ford algorithm

* Works with negative weights. If there is a negative weight cycle reachable from source, the algorithm detects it.

* Total running time = **O(VE)**.

#### Single source SP in DAG

* Even if there are negative weights, negative cycles don't exist in a DAG.

* Total running time = **O(V + E)**.

#### Dijkstra's algorithm

* Works only with non negative edge weights.

* Total running time = **O((V + E)log V)**.