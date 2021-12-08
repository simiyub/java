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

    @Test
    void differenceTest2() {
        int[] expected = new int[]{-123, -124};
        int[] firstArray = new int[]{10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123};
        int [] secondArray = new int[]{-1441, -124, -25, 1014, 1500, 660, 410, 245, 530};
        assertArrayEquals(expected,new SmallestDifferenceImpl().difference(firstArray,secondArray));
    }

    @Test
    void differenceTestZero2() {
        int[] expected = new int[]{-1,-1};
        int[] firstArray = new int[]{-1,5,10, 20, 28,3};
        int [] secondArray = new int[]{-1,134,135,15,17};
        assertArrayEquals(expected,new SmallestDifferencePointerImpl().difference(firstArray,secondArray));
    }

    @Test
    void differenceTest12() {
        int[] expected = new int[]{20, 17};
        int[] firstArray = new int[]{-1,5,10, 20,3};
        int [] secondArray = new int[]{26,134,135,15,17};
        assertArrayEquals(expected,new SmallestDifferencePointerImpl().difference(firstArray,secondArray));
    }

    @Test
    void differenceTest23() {
        int[] expected = new int[]{-123, -124};
        int[] firstArray = new int[]{10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123};
        int [] secondArray = new int[]{-1441, -124, -25, 1014, 1500, 660, 410, 245, 530};
        assertArrayEquals(expected,new SmallestDifferencePointerImpl().difference(firstArray,secondArray));
    }
}