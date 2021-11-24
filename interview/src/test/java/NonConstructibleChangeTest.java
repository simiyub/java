import nonconstructiblechange.NonConstructibleChangeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonConstructibleChangeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void nonConstructibleChange1() {
        int expected=2;
        int[] change = new int[]{1,3,4};
        assertEquals(expected, new NonConstructibleChangeImpl().nonConstructibleChange(change));
    }

    @Test
    void nonConstructibleChange2() {
        int expected=20;
        int[] change = new int[]{5,7, 1,1,2,3,22};
        assertEquals(expected, new NonConstructibleChangeImpl().nonConstructibleChange(change));
    }

    @Test
    void nonConstructibleChange3() {
        int expected=32;
        int[] change = new int[]{5, 6, 1, 1, 2, 3, 4, 9};
        assertEquals(expected, new NonConstructibleChangeImpl().nonConstructibleChange(change));
    }

    @Test
    void nonConstructibleChange4() {
        int expected=1;
        int[] change = new int[0];
        assertEquals(expected, new NonConstructibleChangeImpl().nonConstructibleChange(change));
    }
}