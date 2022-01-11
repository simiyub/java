import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CycleInGraphTest {

    @Test
    void testCycleInGraph1(){

        int[][] edges = new int[][] {{1,3},{2,3,4},{0},{},{2,5},{}};
        assertTrue(new CycleInGraphImpl().cycle(edges));
    }

    @Test
    void testCycleInGraph2(){

        int[][] edges = new int[][] {{1, 2}, {2}, {}};
        assertFalse(new CycleInGraphImpl().cycle(edges));
    }


    @Test
    void testCycleInGraph3(){

        int[][] edges = new int[][] {{}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0}};
        assertFalse(new CycleInGraphImpl().cycle(edges));
    }

    @Test
    void testCycleInGraph4(){

        int[][] edges = new int[][] {{}, {0, 3}, {0}, {1, 2}};
        assertTrue(new CycleInGraphImpl().cycle(edges));
    }

}