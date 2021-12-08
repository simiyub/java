import org.junit.jupiter.api.Test;
import threenumbersum.ThreeNumberSumImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeNumberSumTest {

    @Test
    void sum() {
        List<Integer[]> expected = new ArrayList<>();
        expected.add(new Integer[]{-8,5,9});
        expected.add(new Integer[]{-2,2,6});
        expected.add(new Integer[]{-2,3,5});
        expected.add(new Integer[]{1,2,3});
        int[] array = new int[]{1,2,3,-8,9,-2,5,6};
        List<Integer[]> result = new ThreeNumberSumImpl().sum(array,6);
        assertEquals(expected.size(),result.size());
        for (int i=0;i<=expected.size()-1;i++){
            assertArrayEquals(expected.get(i),result.get(i));
        }

    }
}