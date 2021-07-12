package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeSort() {
        int[] array = new Random().ints(20, 5, 100).toArray();
        int[] result = new MergeSort().mergeSort(array);
        assertArrayEquals(array,result);
        assertEquals(Arrays.stream(array).min().orElse(Integer.MIN_VALUE), result[0]);
        assertEquals(Arrays.stream(array).max().orElse(Integer.MAX_VALUE), result[array.length-1]);
    }
}