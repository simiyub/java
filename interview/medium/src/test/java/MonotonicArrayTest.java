import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicArrayTest {

    @Test
    void isMonotonic1() {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        assertTrue(new MonotonicArrayImpl().isMonotonic(array));
    }

    @Test
    void isMonotonic2() {
        int[] array = new int[]{1, 2, 0};
        assertFalse(new MonotonicArrayImpl().isMonotonic(array));
    }

    @Test
    void isMonotonic3() {
        int[] array = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        assertTrue(new MonotonicArrayImpl().isMonotonic(array));
    }

    @Test
    void isMonotonic4() {
        int[] array = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        assertTrue(new MonotonicArrayImpl().isMonotonic(array));
    }

    @Test
    void isMonotonic5() {
        int[] array = new int[0];
        assertTrue(new MonotonicArrayImpl().isMonotonic(array));
    }
    @Test
    void isMonotonic6() {
        int[] array = new int[1];
        assertTrue(new MonotonicArrayImpl().isMonotonic(array));
    }



}