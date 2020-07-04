## Source
check [here](https://www.youtube.com/watch?v=1_zRHgX8Gqw)

#### Connected Components

if there are 4 vertex in a graph, what is minimum number of edges required to make connected component of 4 vertices ?
n - 1 = 3 edges 

#### Spanning Tree
Spanning Tree is a subset of a graph, which has all the nodes connected using minimum number of edges. (n-1)
It should not have a cycle, since it's a Tree.

Q. a graph has 6 vertices and 6 edges connecting vertices in a circle. How many spanning trees I could generate ?  
Ans. 6 Edges, out of those 6 select 5  edges. hence, 6C5 = 6!/(1! 5!) = 6 is solution.

#### Minimum Spanning Tree
Spanning Tree which has minimum weight among all the candidate Spanning Trees
check [this](https://leetcode.com/problems/cheapest-flights-within-k-stops/) example question on minimum spanning tree  

There are two algorithms (Both _Greedy_) to find MST
1. Kruskal's Algorithm
- Sort the input according to the increasing weight
- choose smallest weight edges first
- make sure when adding new edges that no cycle is formed. `cycle detection`.

Kruskla's algorithm chooses smallest edges first, while making sure no cycle is introduced when adding these edges.

Eg. in the implementation here, the cycle detection is done by `union find` Data structure.
Note that you can't use a set to keep track of which vertices you have already used to make up the edges. Eg, you create edge between 1 and 2, then you create edge between 3 and 4.
Your set would include 1,2,3 and 4 but you don't have a way of knowing that there could be an edge between say 2 and 3.

2. Prim's Algorithm
- Sort the input according to the increasing weight
- choose the smallest edge.
- Next, choose the smallest edge out of the candidate edges connected to current `Connected component`.
- At each step, before adding the new node, detect if adding this node will introduce a cycle in the tree(tree, hence no cycle allowed).

Prim's algorithm adds the smallest node in the start and then adds the smallest of the adjacent nodes.  

Check the explanation [here](https://www.youtube.com/watch?v=4ZlRH0eK-qQ)

#### Cycle Detection

Additionally, just for cycle detection, you could do BFS or DFS from one vertex to another and check if there is a path that already exists between two vertices.
If there is a path, that means they are in the same connected component and we should not add edge between these two vertices.
Check [this](https://www.youtube.com/watch?v=mFVivXZrwyg) for reference at time 9:50 with time complexity of O(V + E)  
edges are approximately V^2 hence this way is O(V^2)

It is for this precise reason that we use `Union Find` and not BFS or DFS here for cycle detection. 
