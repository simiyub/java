import findthreelargestnumbers.FindThreeLargestNumbersImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindThreeLargestNumbersTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void find() {
        int[] array = new int[]{1,2, 5, 7, 6, 4, 5,0, 3, 9, 11};
        int[] expected = new int[]{7,9,11};

        assertArrayEquals(expected, new FindThreeLargestNumbersImpl().find(array));
    }

    @Test
    void findWithDuplicates() {
        int[] array = new int[]{1,2, 5, 7, 6, 4, 9, 5,0, 3, 9, 11};
        int[] expected = new int[]{9,9,11};

        assertArrayEquals(expected, new FindThreeLargestNumbersImpl().find(array));
    }

    @Test
    void findWithNegativeNumbers() {
        int[] array = new int[]{-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7};
        int[] expected = new int[]{-2, -1, 7};

        assertArrayEquals(expected, new FindThreeLargestNumbersImpl().find(array));
    }
}