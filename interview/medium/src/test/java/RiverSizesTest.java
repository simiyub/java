import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * How it works
 * ------------
 *
 * */
class RiverSizesTest {

    @Test
    void riverSizes() {
        int[] expected = new int[]{1,2,2,2,5};
        int[][] array = new int[][]{
                new int[]{1,0,0,1,0},
                new int[]{1,0,1,0,0},
                new int[]{0,0,1,0,1},
                new int[]{1,0,1,0,1},
                new int[]{1,0,1,1,0}
            };
        assertArrayEquals(expected,new RiverSizesImpl().riverSizes(array));
    }
}