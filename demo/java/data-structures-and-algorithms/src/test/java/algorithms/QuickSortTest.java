package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        int[] array = new Random().ints(20,10,100).toArray();
        System.out.println(Arrays.toString(array));
        int[] result = new QuickSort().sort(array);
        System.out.println("Sorted:"+Arrays.toString(result));
        Arrays.stream(array).min();
        assertArrayEquals(array,result);
        assertEquals(Arrays.stream(array).min().orElse(Integer.MIN_VALUE),result[0]);
        assertEquals(Arrays.stream(array).max().orElse(Integer.MAX_VALUE),result[array.length-1]);
    }
}