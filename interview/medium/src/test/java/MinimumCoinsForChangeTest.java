import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCoinsForChangeTest {

    @Test
    void testMinimumCoinsForChange(){

        int expected = 7;
        int[] coins = new int[]{1,5,10};
        int target = 7;
        assertEquals(expected,new MinimumCoinsForChangeImpl().minimumCoinsForChange(coins, target));
    }

}