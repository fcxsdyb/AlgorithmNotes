package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

public class Graph {

    /**
     * Definition:
     * Graph
     * 1. Node
     * 2. Edge
     * 3. Directed vs Undirected
     * 4. Representation of the graph
     *      4.1 Adjacency Matrix
     *          0 1 2 3 4
     *        0 0 1 0 0 1
     *        1 1 0 1 1 1
     *        2 0 1 0 1 0
     *        3 0 1 1 0 1
     *        4 1 1 0 1 0
     * Pros: Representation is easy to implement. Edge removal takes O(1) time.
     * Queries like whether there is an edge from vertex 'u' to vertex 'v' are efficient and can be done O(1).
     * Cons: Consumes more space O(V^2) (V is the number of vertex/node)
     * Even if the graph is sparse (contains less number of edges) = waste of space.
     *
     *      4.2 Adjacency List
     *          0 -> 1 -> 4
     *          1 -> 0 -> 4 -> 3 - > 2
     *          2 -> 1 -> 3
     *          3 -> 1 -> 4 -> 2
     *          4 -> 3 -> 0 -> 1
     *      Vertices/Nodes  |V|
     *      Edges           |E|
     * Pros: Space complexity = O(|V| + |E|). Adding a vertex/node to the graph is easier.
     * Cons: Time complexity is O(V) to check whether there is an edge from a node to the other.
     * (Compared to O(1) in adjacent matrix)
     *      4.2 b Using a hashtable
     *          <key = node, value = vector of successors<node>>
     *              <0, <1, 4>>
     *              <1, <0, 2, 3, 4>>
     *                  ...
     *              <4, <3, 0, 1>>
     *
     */

}
