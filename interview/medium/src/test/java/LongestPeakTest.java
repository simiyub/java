import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPeakTest {

    @Test
    void longestPeak() {
        int expected = 6;
        int[] array = new int[]{1,2,3,3,4, 0,10,6, 5, -1, -3, 2, 3};
        assertEquals(expected,new LongestPeakImpl().longestPeak(array));
    }
}