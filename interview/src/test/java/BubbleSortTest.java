import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sort() {
        int[] expected = new int[]{1,2,3,5,6,7,8,9};
        int[] array = new int[]{6, 7,5, 3, 2,1, 8, 9};
        assertArrayEquals(expected, new BubbleSortImpl().sort(array));
    }


}