package riversizes;

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
    private Set<String> validElementsVisited = new HashSet<>();
    private int[][] rivers;

    @Override
    public List<Integer> riverSizes(int[][] rivers) {
        List<Integer> riverSizes = new ArrayList<>();
        this.rivers =rivers;

        for(int i=0;i<=this.rivers.length-1;i++){

            for (int j=0;j<=this.rivers[i].length-1;j++){
                if(this.rivers[i][j] == 1 && notVisited(i,j)) riverSizes.add(1+traverseRiver(i,j));
            }
        }
        return riverSizes;
    }

    private int traverseRiver(int row, int col) {
        int size = 0;
        int increment = 1;
        validElementsVisited.add(row+"-"+col);

        while (canFlow(col - increment >= 0,row,  col - increment)){
            size = getSize(row, size, col - increment);
            increment++;

        }

        increment = 1;

        while (canFlow(col+increment <= rivers[row].length-1,row,col+increment)){
            size = getSize(row, size, col+increment);
            increment ++;
        }

        increment = 1;
        while (canFlow(row-increment >=0,row-increment,  col)){
            size = getSize(row-increment, size, col);
            increment ++;
        }

        increment = 1;
        while (canFlow(row+increment <= rivers.length-1,row+increment, col)){
            size = getSize(row+increment, size, col);
            increment ++;
        }
        return size;
    }

    private boolean canFlow(boolean baseCondition, int row, int col) {
        return baseCondition && rivers[row][col] == 1 && notVisited(row, col);
    }

    private boolean notVisited(int row, int col){
        return !validElementsVisited.contains(row+"-"+col);
    }

    private int getSize(int row, int size, int i) {
        size++;
        validElementsVisited.add(row + "-" + (i));
        size += traverseRiver(row, i);
        return size;
    }
}
