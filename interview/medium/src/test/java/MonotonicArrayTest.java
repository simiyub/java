import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicArrayTest {
    private int[] testArray1, testArray2, testArray3, testArray4, testArray5, testArray6;
    @BeforeEach
    void setUp() {
        testArray1 = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        testArray2 = new int[]{1, 2, 0};
        testArray3 = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        testArray4 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        testArray5 = new int[0];
        testArray6 = new int[1];
    }

    private void runTests(MonotonicArray impl){
        assertTrue(impl.isMonotonic(testArray1));
        assertFalse(impl.isMonotonic(testArray2));
        assertTrue(impl.isMonotonic(testArray3));
        assertTrue(impl.isMonotonic(testArray4));
        assertTrue(impl.isMonotonic(testArray5));
        assertTrue(impl.isMonotonic(testArray6));
    }

    @Test
    void isMonotonicTestWithDirection() {
        runTests(new MonotonicArrayImpl());
    }

    @Test
    void isMonotonicTestWithoutDirection() {
        runTests(new MonotonicArrayNoDirectionFlagImpl());
    }

}