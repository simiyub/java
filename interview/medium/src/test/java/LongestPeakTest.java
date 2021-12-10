import longestpeak.LongestPeakPeakFirstImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPeakTest {

//    @Test
//    void longestPeakTrendingTest() {
//        int expected = 6;
//        int[] array = new int[]{1,2,3,3,4, 0,10,6, 5, -1, -3, 2, 3};
//        assertEquals(expected,new longestpeak.LongestPeakTrendingImpl().longestPeak(array));
//    }

    @Test
    void longestPeakPeakFirstTest1() {
        int expected = 6;
        int[] array = new int[]{1,2,3,3,4, 0,10,6, 5, -1, -3, 2, 3};
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }

    @Test
    void longestPeakPeakFirstTest2() {
        int expected = 3;
        int[] array = new int[]{1,3,2};
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }

    @Test
    void longestPeakPeakFirstTest3() {
        int expected = 0;
        int[] array = new int[0];
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }

    @Test
    void longestPeakPeakFirstTest4() {
        int expected = 6;
        int[] array = new int[]{1, 2, 3, 4, 5, 1};
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }

    @Test
    void longestPeakPeakFirstTest5() {
        int expected = 3;
        int[] array = new int[]{5, 4, 3, 2, 1, 2, 1};
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }

    @Test
    void longestPeakPeakFirstTest6() {
        int expected = 0;
        int[] array = new int[]{5, 4, 3, 2, 1, 2, 10, 12};
        assertEquals(expected,new LongestPeakPeakFirstImpl().longestPeak(array));
    }


}