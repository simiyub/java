import findsubarrayinarray.FindSubArrayInArray;
import findsubarrayinarray.FindSubArrayInArrayImpl;
import findsubarrayinarray.FindSubArrayInArrayWithArrayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSubArrayInArrayTest {
    private static int[] array1,array2, array3, array4, array5, array6;
            private static int[] potentialSubArray1, potentialSubArray2, potentialSubArray3, potentialSubArray4, potentialSubArray5, potentialSubArray6;

    @BeforeEach
    void setUp() {
        array1 = new int[]{1,2};
        potentialSubArray1 = new int[]{1,2};
        array2 = new int[]{1,3,4};
        potentialSubArray2 = new int[]{1,4};
        array3 = new int[]{1,1,1,1,1};
        potentialSubArray3 = new int[]{1,1,1};
        array4 = new int[] {5, 1, 22, 25, 6, -1, 8, 10};
        potentialSubArray4 = new int[]{5, 1, 22, 25, 6, -1, 8, 10, 12};
        array5 = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        potentialSubArray5 = new int[]{1, 6, -1, -1};
        array6 = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        potentialSubArray6 = new int[]{1, 6, -1, -2};
    }

    private void runTest(FindSubArrayInArray impl){

        assertTrue(impl.isSubArray(array1,potentialSubArray1));
        assertTrue(impl.isSubArray(array2,potentialSubArray2));
        assertTrue(impl.isSubArray(array3,potentialSubArray3));
        assertFalse(impl.isSubArray(array4, potentialSubArray4));
        assertFalse(impl.isSubArray(array5,potentialSubArray5));
        assertFalse(impl.isSubArray(array6, potentialSubArray6));
    }

    @Test
    void isSubArrayWithArray() {
        runTest(new FindSubArrayInArrayWithArrayImpl());
    }

    @Test
    void isSubArray() {
        runTest(new FindSubArrayInArrayImpl());
    }


}