package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;


public class FreeCodeCampCourse {



    /**
     * Seed the array
     * Create an array with size greater than the value provided by 1.
     * Fibonacci requires a sum. So we start off by initialisng the array with zeros.
     * The first value stays as zero
     * The index corresponds to a gfi
     * */
    public static int fibTabulation(int target) {

        int[] fibs = new int[target+1];
        Arrays.fill(fibs,0);
        //seeding index 1
        fibs[1] = 1;
        for(int i=2;i<=target;i++) fibs[i] = fibs[i-1] + fibs[i-2];

        return fibs[target];
    }

    /**
     Travel down a 2D grid from top left corner to the bottom right corner.
     You can only travel down or right.
     In how many ways can you travel to the goal on a grid with dimensions of m * n
     Rectangle not necessarily a square
     visualise some simple example
     grid_traversal(2,3) => 3
     grid_traversal(1,1) => 1 - Do nothing as you are already at the bottom right
     grid_traversal(0,1) => 0 - invalid as the grid is zero
     if any of the dimensions is zero then there's no path to traverse
     grid_traversal(3,3) => 3
     Every step towards the bottom right shrinks our problem and grid towards the base case of (1,1)
     Every times, structure the problem as a tree to visualise
     grid_traversal(2,3) => 3
     knowing the result of a simple examples, we can visualise our logic
     * */
    public static int gridTravel(int width, int height){
        int[][] array = new int[width+1][height+1];
        array[1][1] = 1;
        for(int i=1;i<=width; i++){

            for (int j=1;j<=height; j++){

                array[i][j] += array[i-1][j];
                array[i][j] += array[i][j-1];
            }
        }
        Arrays.stream(array).forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("*****************");
        return array[width][height];
    }
}
