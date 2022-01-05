import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * O(wh) T O(wh) S as we traverse the multidimensional matrix once
 * from top to bottom, left to right and track the elements we have
 * reviewed and determined if it is part of a river or not.
 *
 * How it works
 * ------------
 * we iterate through the multidimensional array and whenever we find a
 * 1, we follow through, identifying any further parts of the river(1)
 * and add to the size. Once we determine that no more consecutive 1s
 * exist, we add the size to the array that is returned.
 *
 * */

public class RiverSizesImpl implements RiverSizes{
    private  Set<String> validElementsVisited = new HashSet<>();
    private int[][] rivers;

    @Override
    public List<Integer> riverSizes(int[][] rivers) {
        List<Integer> riverSizes = new ArrayList<>();
        this.rivers =rivers;

        for(int i=0;i<=this.rivers.length-1;i++){

            for (int j=0;j<=this.rivers[i].length-1;j++){
                if(this.rivers[i][j] == 1 && !visited(i,j)) riverSizes.add(1+traverseRiver(i,j));
            }
        }
        return riverSizes;
    }

    private boolean visited(int row, int col){
        return validElementsVisited.contains(row+"-"+col);
    }

    private int traverseRiver(int row, int col) {
        int size = 0;
        int increment = 1;
        validElementsVisited.add(row+"-"+col);

        while (col-1>=0 && rivers[row][col-increment]==1 && !visited(row,col-increment)){
            size ++;
            validElementsVisited.add(row+"-"+(col-increment));
            size+=traverseRiver(row, col-increment);
            increment++;

        }

        increment = 1;

        while (col+increment <= rivers[row].length-1 && rivers[row][col+increment]==1 && !visited(row,col+increment)){
            size ++;
            validElementsVisited.add(row+"-"+(col+increment));
            size+=traverseRiver(row, col+increment);
            increment ++;
        }

        increment = 1;
        while (row-increment >=0 && rivers[row-increment][col]==1 && !visited(row-increment,col)){
            size ++;
            validElementsVisited.add((row-increment)+"-"+col);
            size+=traverseRiver(row-increment, col);
            increment ++;
        }

        increment = 1;
        while (row+increment <= rivers.length-1 && rivers[row+increment][col]==1 && !visited(row+increment,col)){
            size ++;
            validElementsVisited.add((row+increment)+"-"+col);
            size+=traverseRiver(row+increment, col);
            increment ++;
        }
        return size;
    }
}
