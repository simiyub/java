import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RiverSizesTest {

    @Test
    void riverSizes() {
        List<Integer> expected = List.of(1,2,2,2,5);
        int[][] array = new int[][]{
                new int[]{1,0,0,1,0},
                new int[]{1,0,1,0,0},
                new int[]{0,0,1,0,1},
                new int[]{1,0,1,0,1},
                new int[]{1,0,1,1,0}
            };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }
}