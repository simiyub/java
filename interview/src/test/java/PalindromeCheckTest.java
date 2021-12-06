import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {

    @Test
    void isPalindrome() {
        String value = "";
        assertTrue(new PalindromeCheckImpl().isPalindrome(value));
    }
}