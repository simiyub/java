import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

class SumTwoNumbersInArrayToTargetSumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sum() {
        int[] expectedResult = new int[]{5,5};
        int target = 10;
        int[] array = new int[]{5,5};
        assertArrayEquals(expectedResult, new SumTwoNumbersInArrayToTargetSumImpl().sum(array, target));
    }
}