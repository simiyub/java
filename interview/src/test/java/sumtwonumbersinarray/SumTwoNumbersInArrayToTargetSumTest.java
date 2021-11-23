package sumtwonumbersinarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sumtwonumbersinarray.SumTwoNumbersInArrayToTargetSum;
import sumtwonumbersinarray.SumTwoNumbersInArrayToTargetSumHashTableImpl;
import sumtwonumbersinarray.SumTwoNumbersInArrayToTargetSumSortImpl;
import sumtwonumbersinarray.SumTwoNumbersInArrayToTargetSumTwoLoopImpl;

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

    private void runTest(SumTwoNumbersInArrayToTargetSum impl){
        int[] expectedResult1 = impl.sum(array1, target1);
        assertEquals(target1, (expectedResult1[0] +expectedResult1[1]));

        int[] expectedResult2 = impl.sum(array2, target2);
        assertEquals(target2, (expectedResult2[0] +expectedResult2[1]));


        int[] expectedResult3 = impl.sum(array3, target3);
        assertEquals(target3, (expectedResult3[0] +expectedResult3[1]));
    }

    @Test
    void sumWithTwoLoops() {
        runTest(new SumTwoNumbersInArrayToTargetSumTwoLoopImpl());
    }

    @Test
    void sumWithHashTable(){
       runTest(new SumTwoNumbersInArrayToTargetSumHashTableImpl());
    }

    @Test
    void sumWithSorting(){
        runTest(new SumTwoNumbersInArrayToTargetSumSortImpl());
    }
}