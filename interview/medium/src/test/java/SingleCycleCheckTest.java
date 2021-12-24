import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleCycleCheckTest {

    @Test
    void testHasSingleCycle(){

        int[] array = new int[]{2,3,1,-4,-4,2};
        assertTrue(new SingleCycleCheckImpl().hasSingleCycle(array));
    }

}