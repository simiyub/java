import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

class SumTwoNumbersInArrayToTargetSumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sum() {

        int target = 10;
        int[] array = new int[]{545,2,1,3,5,1,7,8,9,1,2,3,4,3,5};
        int[] expectedResult = new SumTwoNumbersInArrayToTargetSumImpl().sum(array, target);
        assertEquals(target, (expectedResult[0] +expectedResult[1]));

        int[] array2 = new int[]{4,6};
        int[] expectedResult2 = new SumTwoNumbersInArrayToTargetSumImpl().sum(array2, target);
        assertEquals(target, (expectedResult2[0] +expectedResult2[1]));

        int[] array3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedResult3 = new SumTwoNumbersInArrayToTargetSumImpl().sum(array3, 17);
        assertEquals(17, (expectedResult3[0] +expectedResult3[1]));
    }
}