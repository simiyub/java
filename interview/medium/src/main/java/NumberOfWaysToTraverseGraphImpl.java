/**
 * O(nm) T O(nm) S as we traverse two arrays to determine the
 * total number of ways to traverse the graph.
 *
 * How it works
 * ------------
 *In this implementation, we work out the number of ways to each cell
 * in the graph starting at point 0,0 and adding 1 to the count of paths
 * from adjacent sides until we get to the end.
 * */
public class NumberOfWaysToTraverseGraphImpl implements NumberOfWaysToTraverseGraph{
    @Override
    public int count(int width, int height) {
        int[][] ways = new int[width][height];
        for(int row=0;row<ways[0].length;row++) ways[0][row] =  1;
        for(int col=0;col<ways.length;col++) ways[col][0] = 1;

        for(int row=1;row<ways.length;row++){

            for(int col=1;col<ways[row].length;col++){
                ways[row][col] = ways[row][col-1]+ways[row-1][col];
            }
        }
        return ways[ways.length-1][ways[0].length-1];
    }
}
