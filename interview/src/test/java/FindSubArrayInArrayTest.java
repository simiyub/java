import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindSubArrayInArrayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void isSubArray1() {
        int[] array = new int[]{1,2};
        int[] potentialSubArray = new int[]{1,2};
        assertTrue(new FindSubArrayInArrayImpl().isSubArray(array,potentialSubArray));
    }

    @Test
    void isSubArray2() {
        int[] array = new int[]{1,3,4};
        int[] potentialSubArray = new int[]{1,4};
        assertTrue(new FindSubArrayInArrayImpl().isSubArray(array,potentialSubArray));
    }

    @Test
    void isSubList1() {
        List<Integer> array = Arrays.asList(1,1,1,1,1);
        List<Integer> potentialSubArray = Arrays.asList(1,1,1);
        assertTrue(new FindSubArrayInArrayImpl().isSubList(array,potentialSubArray));
    }


}