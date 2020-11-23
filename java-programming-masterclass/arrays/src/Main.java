import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        creatingArrays();
//        example();
//        challenge();
//       minimumElementChallenge();
        int [] array={1,2,3,4,5};
        reverseArrayChallenge(array);

    }

    private static void reverseArrayChallenge(int[] reverse) {

        reverseArray(reverse);
        timReverseSolution(reverse);
    }

    private static void timReverseSolution(int[] reverse) {
        System.out.println("before reverse:"+Arrays.toString(reverse));
        int maxIndex=reverse.length-1;
        int halfLength=reverse.length/2;
        for (int i=0;i<halfLength;i++){
            int temp = reverse[i];
            reverse[i] = reverse[maxIndex-i];
            reverse[maxIndex-i]=temp;
        }
        System.out.println("after reversal:"+Arrays.toString(reverse))   ;
    }

    private static void reverseArray(int[] reverse) {
        System.out.println("before reverse:"+Arrays.toString(reverse));
        int[] reversed=new int[reverse.length];
        int count = 0;
        for(int i=reverse.length-1;i>=0;i--){
            reversed[count]=reverse[i];
            count++;
        }
        System.out.println("after reversal:"+Arrays.toString(reversed))   ;
    }

    private static void minimumElementChallenge() {
        String action="find minimum";
        int count=getInputCount(action);
        int[] array=getIntegers(count,action);
        int min=findMin(array);
        System.out.println("The minimum number in "+Arrays.toString(array)+" is "+min);
    }

    private static int getInputCount(String action) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter count of numbers you will "+action);
        return scanner.nextInt();
    }

    private static int findMin(int[] numbers) {
        int min=numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        return min;
    }


    private static void creatingArrays() {
        //one way to create arrays
        int[] intArray=new int[10];
        intArray[5]=50;
        intArray[3]=20;
        System.out.println("value at index 5="+intArray[5]);

        //second way to create an array
        double[] doubleArray= {3.5,2.5,};
        System.out.println("item at index 1:"+doubleArray[1]);

        //third way
        int [] array3= new int[10];
        for(int i=0;i<array3.length;i++){
            array3[i]=i*10;
        }
        printArray(array3);
    }

    private static void example() {
        String action = "average";
        int[] intArray=getIntegers(getInputCount(action),action );
        printArray(intArray);
        System.out.println("average of these numbers is: "+getAverage(intArray));
    }

    private static void challenge() {
        String action = "sort";
        int[] toSort = getIntegers(getInputCount(action), action);
        printArray(toSort);
        int[] sortedArray=sortArray(toSort);
        System.out.println("sorted:");
        printArray(sortedArray);

        int[] sortedTimsArray=timSortSolution(toSort);
        System.out.println("sorted, Tim's solution:");
        printArray(sortedTimsArray);
    }

    private static int[] timSortSolution(int[] toSort) {
//        int[] sorted = new int[toSort.length];
//        for(int i=0;i<toSort.length;i++){
//            sorted[i]=toSort[i];
//        }
        int[] sorted= Arrays.copyOf(toSort,toSort.length);

        boolean sort=true;
        int holding;
        while(sort) {
            sort=false;
            for (int j = 0; j < sorted.length - 1; j++) {

                if (sorted[j] > sorted[j + 1]) {
                    holding = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = holding;
                    sort = true;
                }
            }
        }
        return sorted;
    }


    private static int[] sortArray(int[] toSort) {
        int[] sorted = new int[toSort.length];
        int sortedIndex=0;
        while(toSort.length>0){
            int least = toSort[0];
            int leastIndex = 0;
            int[] remainingElements=new int[toSort.length-1];
            int remainingElementsIndex=0;

            for(int i=0;i<toSort.length;i++){
                if(toSort[i]<least){
                    least=toSort[i];
                    leastIndex=i;
                    }
            }
            sorted[sortedIndex]=least;
            sortedIndex++;


            for (int j=0;j<toSort.length;j++) {
                if(j!=leastIndex) {
                    remainingElements[remainingElementsIndex]=toSort[j];
                    remainingElementsIndex++;
                }
            }
            toSort=remainingElements;
        }
        return sorted;
    }


    private static double getAverage(int[] intArray) {
        double sum=0;
        for(int i=0;i<intArray.length;i++){
            sum+=intArray[i];
        }
        return (sum/intArray.length);
    }

    private static int[] getIntegers(int numbers, String action) {
        System.out.println("Please enter "+numbers+" integer values to "+action);
        Scanner scanner= new Scanner(System.in);
        int[] values = new int[numbers];
        for(int i=0;i<values.length;i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    private static void printArray(int[] array) {
        for(int i=0;i<array.length;i++){
            System.out.println("element at "+i+" is "+array[i]);
        }

    }
}
