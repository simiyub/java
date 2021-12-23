import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCoinsForChangeTest {

    @Test
    void testMinimumCoinsForChange(){

        int expected = 2;
        int[] coins = new int[]{1,2,4};
        int target = 6;
        assertEquals(expected,new MinimumCoinsForChangeImpl().minimumCoinsForChange(coins, target));
    }

}