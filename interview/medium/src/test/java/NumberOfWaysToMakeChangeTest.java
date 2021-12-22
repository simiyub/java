import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToMakeChangeTest {

    @Test
    void testNumberOfWaysToMakeChangeTest1(){

        int expected = 2;
        int[] array = new int[]{1,5};
        int targetAmount = 6;

        assertEquals(expected,new NumberOfWaysToMakeChangeImpl().numberOfWaysToMakeChange(array, targetAmount));
    }

    @Test
    void testNumberOfWaysToMakeChangeTest2(){

        int expected = 4;
        int[] array = new int[]{1,5, 10, 25};
        int targetAmount = 10;

        assertEquals(expected,new NumberOfWaysToMakeChangeRecursiveImpl().numberOfWaysToMakeChange(array, targetAmount));
    }

    @Test
    void testNumberOfWaysToMakeChangeTest3(){

        int expected = 13;
        int[] array = new int[]{1,5, 10, 25};
        int targetAmount = 25;

        assertEquals(expected,new NumberOfWaysToMakeChangeMemoizationImpl().numberOfWaysToMakeChange(array, targetAmount));
    }

}