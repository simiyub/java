package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArraysDemoImplTest {

    ArraysDemo arraysDemo;
    String[] footballTeam;

    @BeforeEach
    public  void  setup(){
        arraysDemo = new ArraysDemoImpl();
        footballTeam = new String[11];
        footballTeam[0] = "keeper1";
        footballTeam[1] = "teamA No.2";
        footballTeam[2] = "teamB No.3";
        footballTeam[3] = "teamA No.4";
        footballTeam[4] = "teamB No.5";
    }
    @Test
    @DisplayName("initialisation")
    void init() {
        int[] array = arraysDemo.init(1,2,3,4);
        assertEquals(array[3], 4 );
        assertEquals(array.length, 4);

    }

    @Test
    @DisplayName("shortcut initialisation")
    void initShort() {
        char[] array = arraysDemo.initShort('a','b','c','d','e');
        assertEquals(array[4],'e');
        assertEquals(array.length, 5);
    }

    @Test
    @DisplayName("multidimensional array")
    void multiDimensional() {
        String[] stringArray1 = {"one", "two", "three"};
        String[] stringCapArray2 = new String[3];
        stringCapArray2[0] = "One";
        stringCapArray2[1] = "Two";
        stringCapArray2[2] = "Three";
        String[][] array = arraysDemo.multiDimensional(stringArray1,stringCapArray2);
        assertEquals(array[1][1],stringCapArray2[1]);
    }
    @Test
    @DisplayName("array copy")
    void arrayCopy(){
        int[] array1 = {1,2,3};
        int[] array2 = {4,5,6};

        int[] combined = arraysDemo.arrayCopy(array1,array2,true);
        assertEquals(combined.length,array1.length+array2.length);
        assertEquals(combined[5],6);

        combined = arraysDemo.arrayCopy(array1,array2,false);
        assertEquals(combined.length,array1.length+array2.length);
        assertEquals(combined[5],6);
    }


    @Test
    @DisplayName("filling an array")
    void fill() {

        String[] team = arraysDemo.fill(footballTeam,"undecided");
        assertEquals(team[10],"undecided");

    }

    @Test
    @DisplayName("binary search")
    void binarySearch() {
        int index = arraysDemo.binarySearch(footballTeam,"teamB No.5");
        assertEquals(index,4);
    }

    @Test
    @DisplayName("compare arrays for equality")
    void equal() {
        String[] subset = Arrays.copyOfRange(footballTeam,0,4);
        boolean equal = arraysDemo.equal(subset,Arrays.copyOfRange(footballTeam,0, 4));
       assertTrue(equal);
    }

    @Test
    @DisplayName("sort elements in an array")
    void sort() {
        String[] array = arraysDemo.sort(footballTeam);
        assertEquals(array[1],footballTeam[1]);
    }

    @Test
    @DisplayName("remove an element from an array")
    void remove() {
        String removeElement = footballTeam[4];
        String[] array = arraysDemo.remove(footballTeam,removeElement);

        assertFalse(arraysDemo.binarySearch(array,removeElement)==0);
    }
}