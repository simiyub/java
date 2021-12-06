import org.junit.jupiter.api.Test;
import selectionsort.SelectionSortImpl;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sortTest1() {
        int[] expected = new int[]{1,3,5,6,7,8,8};
        int[] array = new int[]{5,3,1,8,7,6,8};
        assertArrayEquals(expected, new SelectionSortImpl().sort(array));
    }

    @Test
    void sortTest2() {
        int[] expected = new int[]{2, 3, 5, 5, 6, 8, 9};
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        assertArrayEquals(expected, new SelectionSortImpl().sort(array));
    }

    @Test
    void sortTest3() {
        int[] expected = new int[]{1,2};
        int[] array = new int[]{2,1};
        assertArrayEquals(expected, new SelectionSortImpl().sort(array));
    }
}