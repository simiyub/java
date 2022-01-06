package riversizes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizesAlternativeImpl implements RiverSizes{
    @Override
    public List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i< matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                if(visited[i][j]) continue;
                traverseNode(i,j,matrix,visited,sizes);
            }
        }
        return sizes;
    }

    private void traverseNode(int row, int col, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        Stack<Integer[]> nodesToExplore =  new Stack<>();
        nodesToExplore.push(new Integer[]{row,col});

        while (!nodesToExplore.empty()){
            Integer[] currentNode = nodesToExplore.pop();
            row = currentNode[0];
            col = currentNode[1];

            if(visited[row][col]) continue;

            visited[row][col] = true;

            if (matrix[row][col] == 0) continue;

            currentRiverSize ++;
            List<Integer[]> unvisitedNeighbours = getUnvisitedNeighbours(row,col,matrix,visited);

            nodesToExplore.addAll(unvisitedNeighbours);

        }
        if(currentRiverSize>0) sizes.add(currentRiverSize);
    }

    private List<Integer[]> getUnvisitedNeighbours(int row, int col, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbours = new ArrayList<>();
        if(row>0 && !visited[row-1][col]) unvisitedNeighbours.add(new Integer[]{row-1,col});
        if(row<matrix.length-1 && !visited[row+1][col]) unvisitedNeighbours.add(new Integer[]{row+1,col});
        if(col>0 && !visited[row][col-1]) unvisitedNeighbours.add(new Integer[]{row, col-1});
        if(col<matrix[0].length-1 && !visited[row][col+1]) unvisitedNeighbours.add(new  Integer[]{row,col+1});
        return unvisitedNeighbours;
    }
}
