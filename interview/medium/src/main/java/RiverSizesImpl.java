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
 *
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
                if(this.rivers[i][j] == 1) riverSizes.add(traverseRiver(i,j));
            }
        }
        return riverSizes;
    }

    private boolean visited(int row, int col){
        return validElementsVisited.contains(row+"-"+col);
    }

    private int traverseRiver(int vert, int hor) {
        int size = 1;
        int increment = 1;
        validElementsVisited.add(vert+"-"+hor);

        while (hor-1>=0 && rivers[vert][hor-increment]==1 && !visited(vert,hor-increment)){
            size ++;
            validElementsVisited.add(vert+"-"+(hor-increment));
            increment++;
        }

        increment = 1;

        while (hor+increment <= rivers.length-1 && rivers[vert][hor+increment]==1 && !visited(vert,hor+increment)){
            size ++;
            validElementsVisited.add(vert+"-"+(hor+increment));
            increment ++;
        }

        increment = 1;
        while (vert-increment >=0 && rivers[vert-increment][hor]==1 && !visited(vert-increment,hor)){
            size ++;
            validElementsVisited.add((vert-increment)+"-"+hor);
            increment ++;
        }

        increment = 1;
        while (vert+increment <= rivers.length-1 && rivers[vert+increment][hor]==1 && !visited(vert+increment,hor)){
            size ++;
            validElementsVisited.add((vert+increment)+"-"+hor);
            increment ++;
        }
        return size;
    }
}
