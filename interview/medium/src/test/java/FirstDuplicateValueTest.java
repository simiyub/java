import firstduplicate.FirstDuplicateValueImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstDuplicateValueTest {

    @Test
    void firstDuplicate1() {
        int expected = 2;
        int[] array = new int[]{2, 1,5,2,3,3,4};

        assertEquals(expected, new FirstDuplicateValueImpl().firstDuplicate(array));
    }

    @Test
    void firstDuplicate2() {
        int expected = 3;
        int[] array = new int[]{3, 1, 3, 1, 1, 4, 4};

        assertEquals(expected, new FirstDuplicateValueImpl().firstDuplicate(array));
    }
}