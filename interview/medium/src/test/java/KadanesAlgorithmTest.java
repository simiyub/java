import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KadanesAlgorithmTest {

    @Test
    void testGreatestSumFromSubArray1(){

        int expected = 19;
        int[] array = new int[]{3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
        assertEquals(expected, new KadanesAlgorithmImpl().greatestSumFromSubArray(array));
    }

    @Test
    void testGreatestSumFromSubArray2(){

        int expected = -10;
        int[] array = new int[]{-10};
        assertEquals(expected, new KadanesAlgorithmImpl().greatestSumFromSubArray(array));
    }

}