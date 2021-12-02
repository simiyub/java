import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void indexOf(){
        int[] array = new int[]{0,1,21,33,45,45,61,71,71,73};
        int required = 33;
        int expected = 3;
        assertEquals(expected, new BinarySearchImp().indexOf(array, required));
    }
}