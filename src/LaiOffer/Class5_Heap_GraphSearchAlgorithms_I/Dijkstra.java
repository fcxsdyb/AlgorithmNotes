package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

public class Dijkstra {

    /**
     * Compared to Best First Search, Dijkstra's algorithm focus more on find the shortest path rather than find path.
     * Compared to Breadth First Search using queue, Dijkstra's algorithm uses priority queue.
     *
     * Usage: Find the shortest path cost from a single node (source node) to any other nodes in that graph
     * Example problem: What is the shortest distance from Beijing to all other major cities in China?
     * Data structure: Priority Queue (MIN_HEAP)
     * Idea for solving the problems:
     *      1. Initial state (start node)
     *      2. Node expansion/Generation rule
     *      3. Termination condition
     *
     * Properties:
     *      1. One node can be expanded once and only once.
     *      2. One node can be generated more than once. (cost can be reduced over time)
     *      3. All the cost of the nodes that are expanded are monotonically non-decreasing.
     *      4. Time complexity, for a graph with n node and the connectivity of the node is O(n log n).
     *      5. When a node is popped out for expansion, its value is fixed which is equal to
     *      the shortest distance from the start node.
     */

}