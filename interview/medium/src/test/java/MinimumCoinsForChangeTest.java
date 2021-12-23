import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCoinsForChangeTest {

    @Test
    void testMinimumCoinsForChange1(){

        int expected = 2;
        int[] coins = new int[]{1,2,4};
        int target = 6;
        assertEquals(expected,new MinimumCoinsForChangeImpl().minimumCoinsForChange(coins, target));
    }


    @Test
    void testMinimumCoinsForChange2(){

        int expected = 3;
        int[] coins = new int[]{1,5,10};
        int target = 7;
        assertEquals(expected,new MinimumCoinsForChangeImpl().minimumCoinsForChange(coins, target));
    }

    @Test
    void testMinimumCoinsForChange3(){

        int expected = 2;
        int[] coins = new int[]{2,1};
        int target = 3;
        assertEquals(expected,new MinimumCoinsForChangeImpl().minimumCoinsForChange(coins, target));
    }
}