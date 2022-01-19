import java.util.Arrays;


/**
 * O(v+e) T and O(v) S This is because we iterate through
 * the array reviewing the vertices and adjacent vertices and in worst case,
 * we would have to review all of them, hence v+e.
 *
 * How it works
 * ------------
 * We initialise an array to store the colours of the nodes then we
 * use this array to determine if a node has been visited or not.
 * If in our review of the adjacent vertices we reach a node that
 * is currently in our stack, we know we have found a cycle and return true.
 * */
public class CycleInGraphImpl implements CycleInGraph {

    int WHITE = 0;
    int BLACK = 2;
    int GREY = 1;

    @Override
    public boolean cycle(int[][] edges) {

        int[] colours = new int[edges.length];
        Arrays.fill(colours, WHITE);

        for(int i=0;i<=edges.length-1;i++){
            boolean hasCycle = hasCycle(i, colours, edges);
            if(hasCycle) return true;
        }

        return false;
    }

    private boolean hasCycle(int node, int[] colours, int[][] edges) {
        colours[node] = GREY;
        for(int edge:edges[node]) {
            if (colours[edge] == GREY) return true;
            if (colours[edge] == WHITE )if(hasCycle(edge,colours,edges)) return true;
        }
        colours[node] =BLACK;
        return false;
    }
}
