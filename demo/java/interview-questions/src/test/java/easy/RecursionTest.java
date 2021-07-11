package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    @Test
    void fibonacci() {
        int[] fib = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597};
        assertArrayEquals(fib, Recursion.run(18));
    }
}