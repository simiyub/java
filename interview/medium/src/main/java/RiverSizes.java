import java.util.List;

/**
 * This function takes a two dimension matrix
 * and returns an array of the size of rivers in the array.
 * A river is represented by 1.
 * 1 without any other 1s adjacent to it a river of size 1.
 * Adjacency can be vertical, horizontal or both. For example:
 * [
 * [1,0,0,1,0]
 * [1,0,1,0,0]
 * [0,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,1,0]
 * ]
 * should return [1,2,2,2,5]
 * */
public interface RiverSizes {

    List<Integer> riverSizes(int[][] rivers);

}
