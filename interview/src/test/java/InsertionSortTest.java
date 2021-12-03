import insertionsort.InsertionSortImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        int[] expected = new int[]{1,3,5,6,7,8,9};
        int[] array = new int[]{5,6,1,3,7,9, 8};
        assertArrayEquals(expected, new InsertionSortImpl().sort(array));
    }
}