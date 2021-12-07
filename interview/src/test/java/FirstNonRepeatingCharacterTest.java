import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingCharacterTest {

    @Test
    void firstNonRepeatingCharacterIndex() {
        int expected = 1;
        String string="asahi";
        assertEquals(expected,new FirstNonRepeatingCharacterImpl().firstNonRepeatingCharacterIndex(string));
    }
}