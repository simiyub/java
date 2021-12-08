import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smallestdifference.SmallestDifference;
import smallestdifference.SmallestDifferenceIterationImpl;
import smallestdifference.SmallestDifferencePointerImpl;

import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {
    int[] expectedTest1,expectedTest2,expectedTest3;
    int[] firstArrayTest1, firstArrayTest2, firstArrayTest3;
    int [] secondArrayTest1, secondArrayTest2, secondArrayTest3;
    @BeforeEach
    void setUp() {
        expectedTest1 = new int[]{-1,-1};
        firstArrayTest1 = new int[]{-1,5,10, 20, 28,3};
        secondArrayTest1 = new int[]{-1,134,135,15,17};

        expectedTest2 = new int[]{20, 17};
        firstArrayTest2 = new int[]{-1,5,10, 20,3};
        secondArrayTest2 = new int[]{26,134,135,15,17};

        expectedTest3 = new int[]{-123, -124};
        firstArrayTest3 = new int[]{10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123};
        secondArrayTest3 = new int[]{-1441, -124, -25, 1014, 1500, 660, 410, 245, 530};


    }

    private void runTest(SmallestDifference impl){
        assertArrayEquals(expectedTest1,impl.difference(firstArrayTest1,secondArrayTest1));
        assertArrayEquals(expectedTest2,impl.difference(firstArrayTest2,secondArrayTest2));
        assertArrayEquals(expectedTest3,impl.difference(firstArrayTest3,secondArrayTest3));
    }

    @Test
    void SmallestDifferenceIterationImpl() {
        runTest(new SmallestDifferenceIterationImpl());
    }

    @Test
    void SmallestDifferencePointerImpl() {
        runTest(new SmallestDifferencePointerImpl());
    }
}