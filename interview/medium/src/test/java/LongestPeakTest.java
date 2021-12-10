import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPeakTest {

//    @Test
//    void longestPeakTrendingTest() {
//        int expected = 6;
//        int[] array = new int[]{1,2,3,3,4, 0,10,6, 5, -1, -3, 2, 3};
//        assertEquals(expected,new LongestPeakTrendingImpl().longestPeak(array));
//    }

    @Test
    void longestPeakPeakFirstTest() {
        int expected = 6;
        int[] array = new int[]{1,2,3,3,4, 0,10,6, 5, -1, -3, 2, 3};
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }
}