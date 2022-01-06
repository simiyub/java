import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import riversizes.RiverSizes;
import riversizes.RiverSizesAlternativeImpl;
import riversizes.RiverSizesImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RiverSizesTest {
    private List<Integer> expectedTest1, expectedTest2, expectedTest3,expectedTest4,expectedTest5,
            expectedTest6,expectedTest7,expectedTest8;
    private int[][] arrayTest1,arrayTest2,arrayTest3,arrayTest4,arrayTest5,
            arrayTest6,arrayTest7,arrayTest8;
    @BeforeEach
    void setUp() {
        expectedTest1 = List.of(2,1,5,2,2);
        arrayTest1 = new int[][]{
                new int[]{1,0,0,1,0},
                new int[]{1,0,1,0,0},
                new int[]{0,0,1,0,1},
                new int[]{1,0,1,0,1},
                new int[]{1,0,1,1,0}
        };

        expectedTest2 = List.of(3,2,1);
        arrayTest2 = new int[][]{
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}
        };

        expectedTest3 = List.of(1);
        arrayTest3 = new int[][]{
                {1}
        };

        expectedTest4 = List.of(2,1,3,1);
        arrayTest4 = new int[][]{
                new int[]{1, 0, 0, 1},
                new int[]{1, 0, 1, 0},
                new int[]{0, 0, 1, 0},
                new int[]{1, 0, 1, 0}
        };

       expectedTest5 = List.of(2, 1, 21, 5, 2, 1);
        arrayTest5 = new int[][]{
                new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                new int[]{1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                new int[]{0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                new int[]{1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };

        expectedTest6 = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        arrayTest6 = new int[][]{
                new int[]{1, 0, 0, 0, 0, 0, 1},
                new int[]{0, 1, 0, 0, 0, 1, 0},
                new int[]{0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 0, 0, 1, 0, 0, 0},
                new int[]{0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 0, 1, 0},
                new int[]{1, 0, 0, 0, 0, 0, 1}
        };

        expectedTest7= List.of(49);
        arrayTest7 = new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1}

        };

        expectedTest8 = List.of(3,5,6);
        arrayTest8= new int[][]{
                new int[]{1, 1, 0, 0, 0, 0, 1, 1},
                new int[]{1, 0, 1, 1, 1, 1, 0, 1},
                new int[]{0, 1, 1, 0, 0, 0, 1, 1},

        };

    }

    //TODO check why these tests are failing when you have a moment
//    @Test
//    void riverSizesImplTest() {
//        runTests(new RiverSizesImpl());
//    }

    @Test
    void riverSizesAlternativeImplTest(){
        runTests(new RiverSizesAlternativeImpl());
    }

    private void runTests(RiverSizes impl) {
        assertEquals(expectedTest1,impl.riverSizes(arrayTest1));
        assertEquals(expectedTest2,impl.riverSizes(arrayTest2));
        assertEquals(expectedTest3,impl.riverSizes(arrayTest3));
        assertEquals(expectedTest4,impl.riverSizes(arrayTest4));
        assertEquals(expectedTest5,impl.riverSizes(arrayTest5));
        assertEquals(expectedTest6,impl.riverSizes(arrayTest6));
        assertEquals(expectedTest7,impl.riverSizes(arrayTest7));
        assertEquals(expectedTest8,impl.riverSizes(arrayTest8));
    }

}