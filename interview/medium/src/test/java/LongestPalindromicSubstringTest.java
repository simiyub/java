import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindromeTest(){
        String expected = "xyzzyx";

        String string = "abaxyzzyxf";
        String actual = new LongestPalindromicSubstringImpl().longestPalindrome(string);
        assertEquals(expected,actual);
    }


}