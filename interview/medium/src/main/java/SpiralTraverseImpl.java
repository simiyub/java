/**
 *O(N) T O(N) S We iterate through each of the arrays within the array provided once,
 * and we store all the elements in a new array to return.
 * How it works
 * ------------
 * We run through the first array, then down the last elements of all arrays,
 * moving on to all the elements in the last array in reverse order
 * and finally coming back to where we started by selecting the first element in each array
 * stopping before the first array.
 * Effectively, we would have go around the perimeter of the array of arrays.
 * We then repeat the process, this time inside the perimeter we covered the first time.
 * We continue with this process until we have covered all the elements then return the array
 * of all the elements obtained.
 * This requires tracking the start and end elements of our traversal.
 * Example:
 * [
 *  [ 1, 2, 3, 4],
 *  [12,13,14, 5],
 *  [11,16,15,6],
 *  [10, 9, 7,8]
 *  ]
 *  returns [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 * */
public class SpiralTraverseImpl implements SpiralTraverse{
    @Override
    public int[] traverse(int[][] array) {
        int xStart = 0;
        int xEnd = array[0].length - 1;
        int yStart = 0;
        int yEnd = array.length - 1;
        int totalElements = 0;
        for(int i=0;i<=array.length-1;i++){
            totalElements += array[i].length;
        }
        int[] result = new int[totalElements];
        int index =0;
     //   int x = 0;
    //    int y = 0;
        while (xStart <= xEnd && yStart <= yEnd) {

            for (int x=xStart; x<= xEnd;x ++) {
                result[index] = array[yStart][x];
                index++;
            }
            for( int y=yStart; y<= yEnd; y++) {
                result[index] = array[y][xEnd];
                index ++;
            }
//            while (x >= xStart) {
//                System.out.println(array[y][x]);
//                x--;
//            }
//
//            while (y >= yStart) {
//                System.out.println(array[y][x]);
//                y--;
//            }

        }
        return new int[0];
    }
}
