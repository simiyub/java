import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSubArrayInArrayTest {
    private static int[] array1,array2, array3, potentialSubArray1, potentialSubArray2, potentialSubArray3;

    @BeforeEach
    void setUp() {
        array1 = new int[]{1,2};
        potentialSubArray1 = new int[]{1,2};
        array2 = new int[]{1,3,4};
        potentialSubArray2 = new int[]{1,4};
        array3 = new int[]{1,1,1,1,1};
        potentialSubArray3 = new int[]{1,1,1};
    }

    private void runTest(FindSubArrayInArray impl){

        assertTrue(impl.isSubArray(array1,potentialSubArray1));
        assertTrue(impl.isSubArray(array2,potentialSubArray2));
        assertTrue(impl.isSubArray(array3,potentialSubArray3));
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