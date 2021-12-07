import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingCharacterTest {

    @Test
    void firstNonRepeatingCharacterIndexTest1() {
        int expected = 1;
        String string="asahi";
        assertEquals(expected,new FirstNonRepeatingCharacterImpl().firstNonRepeatingCharacterIndex(string));
    }
    @Test
    void firstNonRepeatingCharacterIndexTest2() {
        int expected = 6;
        String string="faadabcbbebdf";
        assertEquals(expected,new FirstNonRepeatingCharacterImpl().firstNonRepeatingCharacterIndex(string));
    }
}