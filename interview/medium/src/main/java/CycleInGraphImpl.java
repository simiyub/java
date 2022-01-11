import java.util.Arrays;

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
