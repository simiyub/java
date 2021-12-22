import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToMakeChangeTest {

    @Test
    void testNumberOfWaysToMakeChangeTest(){

        int expected = 2;
        int[] array = new int[]{1,5};
        int targetAmount = 6;

        assertEquals(expected,new NumberOfWaysToMakeChangeImpl().numberOfWaysToMakeChange(array, targetAmount));
    }

}