import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicArrayTest {

    @Test
    void isMonotonic() {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        assertTrue(new MonotonicArrayImpl().isMonotonic(array));
    }
}