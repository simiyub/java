/**
 *This function takes in a list of edges representing
 * an unweighted, directed graph with at least one node.
 * This is an adjacency list with the number of edges = number of vertices
 * and each index in the edges contains it's outbound edges in no order.
 * Each edge is represented by a positive integer that is
 * an index in the list that the vertex is connected to.
 * It returns a boolean of whether the graph contains a circle.
 * A cycle consists of vertices that are connected in a closed circuit.
 * Thus the first vertex in the cycle is the last one.
 * The cycle can consist of a single vertex in which case it is a self-loop.
 * */
public interface CycleInGraph {
    boolean cycle(int[][] edges);
}
