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

   /**
    * In this case, we take a target sum and an array of numbers as arguments.
    * We should return an array containing any combinations of elements that add up to
    * exactly the target sum. If there is no combination that adds up to the target sum,
    * we return null. If there are multiple combinations, then we just return one of them.
    * The implementation in this case is similar to can sum. However, we need to return an array of
    * possible combinations.
    * howSum(7, [5, 3, 4])
    * Complexity
    * To start with, we are iterating through the numbers for each position in the table we
    * have created which adds up to O(m*n). In addition, we are making a copy of the table entries
    * and in worst case scenario, this would be m. As a result we have a time complexity of Om^2 n
    * Space complexity in this case will be O(m^2) given that the table can potentially have
    * up to target number of elements.
    * */
   public static int[] howSum(int target, int[] numbers){
       int[][] table =  new int[target+1][];
       table[0] = new int[0];
       for(int tableIndex=0;tableIndex<=table.length-1;tableIndex++){

           if(table[tableIndex] !=null){

               for(int numberIndex=0;numberIndex<=numbers.length-1;numberIndex++){
                   int resultIndex = tableIndex + numbers[numberIndex];
                   if(resultIndex<=target) {
                       int[] currentArray = table[tableIndex];
                       table[resultIndex] = Arrays.copyOf(currentArray, currentArray.length + 1);
                       table[resultIndex][currentArray.length] = numbers[numberIndex];
                       int[] resultArray = table[resultIndex];
                       int sum = Arrays.stream(resultArray).sum();
                       if( sum==target){
                           System.out.println("found:"+Arrays.toString(resultArray));
                           return resultArray;
                       }
                   }
               }
           }

       }
       return new int[0];
   }
}
