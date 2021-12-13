import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeOverlappingIntervalsTest {

    @Test
            void testMergeOverlappingInterval1(){
        int[][] expected = new int[][]{new int[]{1,2}, new int[]{3,8}, new int[]{9,10}};
        int[][] array = new  int[][]{new int[]{1,2},new int[]{3,5}, new int[]{4,7}, new int[]{6, 8}, new int[]{9,10}};
        assertArrayEquals(expected, new MergeOverlappingIntervalsImpl().mergeOverlappingIntervals(array));
    }


}