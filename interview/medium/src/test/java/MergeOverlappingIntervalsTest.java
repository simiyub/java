import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeOverlappingIntervalsTest {

    @Test
            void testMergeOverlappingInterval1(){
        int[][] expected = new int[][]{new int[]{1,2}, new int[]{3,8}, new int[]{9,10}};
        int[][] array = new  int[][]{new int[]{1,2},new int[]{3,5}, new int[]{4,7}, new int[]{6, 8}, new int[]{9,10}};
        assertArrayEquals(expected, new MergeOverlappingIntervalsImpl().mergeOverlappingIntervals(array));
    }

    @Test
    void testMergeOverlappingInterval2(){
        int[][] expected = new int[][]{new int[]{-50,20}, new int[]{70,95}};
        int[][] array = new  int[][]{new int[]{89, 90},new int[]{-10,20}, new int[]{-50,0}, new int[]{70,90}, new int[]{90,91}, new int[]{90, 95}};
        int[][] actual = new MergeOverlappingIntervalsImpl().mergeOverlappingIntervals(array);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testMergeOverlappingInterval3(){
        int[][] expected = new int[][]{new int[]{9,90}, new int[]{91,93}};
        int[][] array = new  int[][]{new int[]{43, 49},new int[]{9,12}, new int[]{12,54}, new int[]{45,90}, new int[]{91,93}};
        int[][] actual = new MergeOverlappingIntervalsImpl().mergeOverlappingIntervals(array);

        assertArrayEquals(expected, actual);
    }

}