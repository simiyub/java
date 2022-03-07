package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumberSumTest {

    @Test
    void findSumWithSortingImpl() {
        int[] expected = new int[]{-1, 11};
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        assertArrayEquals(expected, new TwoNumberSumWithSortingImpl().findSum(array, 10));
    }
    @Test
    void findSumWithStorageImpl() {
        int[] expected = new int[]{-1, 11};
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        assertArrayEquals(expected, new TwoNumberSumWithStorageImpl().findSum(array, 10));
    }
}