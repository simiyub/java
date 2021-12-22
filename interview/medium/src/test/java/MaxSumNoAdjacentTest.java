import maxsumnoadjacent.MaxSumNoAdjacentImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumNoAdjacentTest {

    @Test
    void sumTest(){
        int expected = 330;
        int[] array = new int[]{75, 105,120, 75, 90, 135};
        assertEquals(expected, new MaxSumNoAdjacentImpl().sum(array));
    }

}