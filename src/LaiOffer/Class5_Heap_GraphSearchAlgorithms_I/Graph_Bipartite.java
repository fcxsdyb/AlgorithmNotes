package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

/**
 * Bipartite : whether a graph's node can be divided into two group.
 * such that the nodes in each group do not have direct edges between the nodes that belong to the same group.
 */
public class Graph_Bipartite {

    /**
     * Solution:
     * Use BFS/DFS to go through all the sets of vertices, give the sign for each node and its linked nodes
     * with different signs. During the traverse, if a vertex have the sign which is the same as the linked nodes,
     * return false. Otherwise, after traverse, return true.
     */

}
