import org.junit.jupiter.api.Test;
import palindrome.PalindromeCheckImpl;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {

    @Test
    void isPalindrome1() {
        String value = "abcdefghhgfedcba";
        assertTrue(new PalindromeCheckImpl().isPalindrome(value));
    }

    @Test
    void isPalindrome2() {
        String value = "abcdefghihgfeddcba";
        assertFalse(new PalindromeCheckImpl().isPalindrome(value));
    }
}