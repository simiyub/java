import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTwoNumbersInArrayToTargetSumTest {

    private static int target1, target2, target3;
    private static  int[] array1, array2, array3;

    @BeforeEach
    void setUp() {
        target1 = 10;
        target2 = 10;
        target3 = 17;
        array1 =  new int[]{545,2,1,3,5,1,7,8,9,1,2,3,4,3,5};
        array2 = new int[]{4,6};
        array3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    void sumWithTwoLoops() {

        int[] expectedResult = new SumTwoNumbersInArrayToTargetSumTwoLoopImpl().sum(array1, target1);
        assertEquals(target1, (expectedResult[0] +expectedResult[1]));

        int[] expectedResult2 = new SumTwoNumbersInArrayToTargetSumTwoLoopImpl().sum(array2, target2);
        assertEquals(target2, (expectedResult2[0] +expectedResult2[1]));


        int[] expectedResult3 = new SumTwoNumbersInArrayToTargetSumTwoLoopImpl().sum(array3, target3);
        assertEquals(target3, (expectedResult3[0] +expectedResult3[1]));
    }

    @Test
    void sumWithHashTable(){
       // int target
        int[] expectedResult1 = new SumTwoNumbersInArrayToTargetSumHashTableImpl().sum(array1, target1);
        assertEquals(target1, (expectedResult1[0] +expectedResult1[1]));

        int[] expectedResult2 = new SumTwoNumbersInArrayToTargetSumHashTableImpl().sum(array2, target2);
        assertEquals(target2, (expectedResult2[0] +expectedResult2[1]));


        int[] expectedResult3 = new SumTwoNumbersInArrayToTargetSumHashTableImpl().sum(array3, target3);
        assertEquals(target3, (expectedResult3[0] +expectedResult3[1]));
    }
}