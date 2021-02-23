package arrays;

import java.util.Arrays;

/****
 * An array is a container object that holds:
 *  - a fixed number of objects of a specific type
 *  - the type and number is determined when the array is created
 * Each item in the array is an element.
 * Each elements is accessed by a numerical index with first item as index 0.
 * Declaration:
 *  - int [] anArray  - Most common
 *  - int anArray [].
 * Initialisation:
 *  - int [] anArray = = new int[4] - Size of 4
 *  Example code below, run the unit tests to see application.
 */

public class ArraysDemoImpl implements ArraysDemo {

    @Override
    public int[] init(int i, int i1, int i2, int i3) {
        int [] array = new int[4];
        array[0] = i;
        array[1] = i1;
        array[2] = i2;
        array[3] = i3;
        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * shortcut initialisation
     * */
    @Override
    public char[] initShort(char a, char b, char c, char d, char e) {
        char array[] =  {a,b,c,d,e};
        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * first element represents the row and second element the column
     * */

    @Override
    public String[][] multiDimensional(String[] stringArray1, String[] stringArray2) {
        String[][] array = new String[2][3];
        array[0][0]=stringArray1[0];
        array[0][1]=stringArray1[1];
        array[0][2]=stringArray1[2];
        array[1][0]=stringArray2[0];
        array[1][1]=stringArray2[1];
        array[1][2]=stringArray2[2];
        for (int i=0;i<array.length;i++){
            System.out.println(Arrays.toString(array[i]));
        }

        return array;
    }

    /**
     * Use arraycopy to copy elements from one array to another
     * **/
    @Override
    public int[] arrayCopy(int[] array1, int[] array2, boolean manual) {
        int[] combined = new int[array1.length + array2.length];
        if (manual) {
            combined[0] = array1[0];
            combined[1] = array1[1];
            combined[2] = array1[2];
            combined[3] = array2[0];
            combined[4] = array2[1];
            combined[5] = array2[2];

        }
        else {
            System.arraycopy(array1,0,combined,0,array1.length);
            System.arraycopy(array2,0,combined,3,array2.length);
        }

        System.out.println(Arrays.toString(combined));

        return combined;
    }

    @Override
    public String[] fill(String[] array, String filler) {
        int firstNullIndex=-1;
        //Arrays.fill(array,firstNull,array.length-1,filler);
        for(int i=0;i<array.length;i++){
            if(array[i]==null){
                firstNullIndex = i;
                break;
            }
        }
        if(firstNullIndex!=-1){
            Arrays.fill(array,firstNullIndex,array.length,filler);
        }

        return array;
    }

    @Override
    public int binarySearch(String[] array, String searchElement) {
        array = fill(array,"undecided");
        Arrays.sort(array);
        System.out.println(array);
        return  Arrays.binarySearch(array,searchElement);
    }

    @Override
    public boolean equal(String[] array1, String[] array2) {
        return Arrays.equals(array1,array2);
    }

    @Override
    public String[] sort(String[] array) {
        array = fill(array,"undecided");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        return array;
    }

    @Override
    public String[] remove(String[] array, String removeElement) {
        int index = binarySearch(array,removeElement);
        if(index!=-1){
            String[] array1 = Arrays.copyOfRange(array,0,index-1);
            String[] array2 = Arrays.copyOfRange(array,index+1,array.length-1);
            String[] combined = new String[array1.length + array2.length];
            System.arraycopy(array1,0,combined,0,array1.length);
            System.arraycopy(array2,0,combined,array1.length,array2.length);
            return combined;
        }

        return array;
    }
}
