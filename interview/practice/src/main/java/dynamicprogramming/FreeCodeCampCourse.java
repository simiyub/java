package dynamicprogramming;

import java.util.Arrays;


public class FreeCodeCampCourse {



    /**
     * Seed the array
     * Create an array with size greater than the value provided by 1.
     * Fibonacci requires a sum. So we start off by initialising the array with zeros.
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
     Every time, structure the problem as a tree to visualise
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

    /**
     * Write a function that takes in a target sum and an array of numbers as arguments.
     * The function should return a boolean indicating if it is possible
     * to generate the target sum using numbers from the array.
     * You may use an element of the array as many times as needed.
     * You may assume that all input numbers are non-negative.
     *complexity - O(nm) T O(m) S
     * */

    public static boolean canSum(int target, int[] array){
        Boolean[] table = new Boolean[target+1];
        Arrays.fill(table,false);
        table[0] = true;
        for(int i=0;i<=table.length-1;i++){

            if(table[i]) {
                for(int j=0;j<=array.length-1;j++){
                    int nextIndex = i+array[j];
                    if(nextIndex<=target) {

                        if (nextIndex == target) {
                            System.out.println("found it");
                            return true;
                        }
                        table[nextIndex] = true;
                    }
                }
            }
        }
        boolean result = table[target];
        System.out.println(result);
        return result;
    }
}
