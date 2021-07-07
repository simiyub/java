package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortImplTest {
    String[] strings;
    private static HeapSort heapSort = new HeapSortImpl();
    private Random random;

    @BeforeEach
    void setUp() {
        String[] strarr = {"hope you find this helpful!", "wef", "rg", "q2rq2r", "avs", "erhijer0g", "ewofij", "gwe", "q", "random"};
    }

    private Integer[] getArray(int size, int upperLimit) {
        random = new Random();
        Integer[] integers = new Integer[size];
        for(int i=0;i<size;i++){
            integers[i] = random.nextInt(upperLimit);
        }
        System.out.println(Arrays.toString(integers));
        return integers;
    }

    @Test
    void maxHeapify() {
        Integer[] in = getArray(2,100);
        Comparable[] arr = heapSort.maxHeapify(in, 1, 2);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(arr, in);
        assertEquals(arr[0],Arrays.stream(in).max(Integer::compareTo).get());
    }

    @Test
    void sort() {
        Integer[] integers = getArray(50,100);
        Integer[] arr = (Integer[]) heapSort.sort(integers);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(arr, integers);
    }
}