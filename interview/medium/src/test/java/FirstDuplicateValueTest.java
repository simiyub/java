import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstDuplicateValueTest {

    @Test
    void firstDuplicate() {
        int expected = 2;
        int[] array = new int[]{2, 1,5,2,3,3,4};

        assertEquals(expected, new FirstDuplicateValueImpl().firstDuplicate(array));
    }
}