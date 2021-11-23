import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSquareArrayFromSortedArrayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sortedSquaredArray() {
        int[] array = new int[]{1,2,3};
        int[] expected = new int[]{1,4,9};
        assertArrayEquals(expected, new SortedSquareArrayFromSortedArrayImpl().sortedSquaredArray(array));
    }
}