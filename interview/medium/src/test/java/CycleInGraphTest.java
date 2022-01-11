import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CycleInGraphTest {

    @Test
    void testCycleInGraph(){

        int[][] edges = new int[][] {{1,3},{2,3,4},{0},{},{2,5},{}};
        assertTrue(new CycleInGraphImpl().cycle(edges));
    }

}