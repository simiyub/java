import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        int[] expected = new int[]{1,3,5,6,7,8,8};
        int[] array = new int[]{5,3,1,8,7,6,8};
        assertArrayEquals(expected, new SelectionSortImpl().sort(array));
    }
}