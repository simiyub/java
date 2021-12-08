import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {

    @Test
    void differenceTestZero() {
        int[] expected = new int[]{-1,-1};
        int[] firstArray = new int[]{-1,5,10, 20, 28,3};
        int [] secondArray = new int[]{-1,134,135,15,17};
        assertArrayEquals(expected,new SmallestDifferenceImpl().difference(firstArray,secondArray));
    }

    @Test
    void differenceTest1() {
        int[] expected = new int[]{28, 26};
        int[] firstArray = new int[]{-1,5,10, 20, 28,3};
        int [] secondArray = new int[]{26,134,135,15,17};
        assertArrayEquals(expected,new SmallestDifferenceImpl().difference(firstArray,secondArray));
    }
}