import org.junit.jupiter.api.Test;
import riversizes.RiverSizesImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RiverSizesTest {

    @Test
    void riverSizes1() {
        List<Integer> expected = List.of(2,1,5,2,2);
        int[][] array = new int[][]{
                new int[]{1,0,0,1,0},
                new int[]{1,0,1,0,0},
                new int[]{0,0,1,0,1},
                new int[]{1,0,1,0,1},
                new int[]{1,0,1,1,0}
            };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }


    @Test
    void riverSizes2() {
        List<Integer> expected = List.of(3,2,1);
        int[][] array = new int[][]{
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}
        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }

    @Test
    void riverSizes3() {
        List<Integer> expected = List.of(1);
        int[][] array = new int[][]{
                {1}
        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }

    @Test
    void riverSizes4() {
        List<Integer> expected = List.of(2,1,3,1);
        int[][] array = new int[][]{
                new int[]{1, 0, 0, 1},
    new int[]{1, 0, 1, 0},
    new int[]{0, 0, 1, 0},
    new int[]{1, 0, 1, 0}
        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }

    @Test
    void riverSizes5() {
        List<Integer> expected = List.of(2, 1, 21, 5, 2, 1);
        int[][] array = new int[][]{
                new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                new int[]{1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                new int[]{0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                new int[]{1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }
    @Test
    void riverSizes6() {
        List<Integer> expected = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int[][] array = new int[][]{
                new int[]{1, 0, 0, 0, 0, 0, 1},
                new int[]{0, 1, 0, 0, 0, 1, 0},
                new int[]{0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 0, 0, 1, 0, 0, 0},
                new int[]{0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 0, 1, 0},
                new int[]{1, 0, 0, 0, 0, 0, 1}
        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }

    @Test
    void riverSizes7() {
        List<Integer> expected = List.of(49);
        int[][] array = new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1}

        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }
    @Test
    void riverSizes8() {
        List<Integer> expected = List.of(3,5,6);
        int[][] array = new int[][]{
                new int[]{1, 1, 0, 0, 0, 0, 1, 1},
                new int[]{1, 0, 1, 1, 1, 1, 0, 1},
                new int[]{0, 1, 1, 0, 0, 0, 1, 1},

        };
        assertEquals(expected,new RiverSizesImpl().riverSizes(array));
    }

}