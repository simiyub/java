import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSquareArrayFromSortedArrayTest {
    private static int[] array1, array2;
    private static int[] expectedResult1, expectedResult2;

    @BeforeEach
    void setUp() {
        array1 = new int[]{1,2,3};
        expectedResult1 = new int[]{1,4,9};
        array2 = new int[]{-3,-2,1};
        expectedResult2 = new int[] {1,4,9};
    }

    @Test
    void sortedSquaredArray() {
        assertArrayEquals(expectedResult1, new SortedSquareArrayFromSortedArrayImpl().sortedSquaredArray(array1));
        assertArrayEquals(expectedResult2, new SortedSquareArrayFromSortedArrayImpl().sortedSquaredArray(array2));
    }


}