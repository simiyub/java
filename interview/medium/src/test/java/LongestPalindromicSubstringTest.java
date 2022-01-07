import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindromeTest1(){
        String expected = "xyzzyx";

        String string = "abaxyzzyxf";
        String actual = new LongestPalindromicSubstringImpl().longestPalindrome(string);
        assertEquals(expected,actual);
    }
    @Test
    public void longestPalindromeTest2(){
        String expected = "noon";

        String string = "it's highnoon";
        String actual = new LongestPalindromicSubstringImpl().longestPalindrome(string);
        assertEquals(expected,actual);
    }
    @Test
    public void longestPalindromeTest3(){
        String expected = "abcdefgfedcba";

        String string = "abcdefgfedcba";
        String actual = new LongestPalindromicSubstringImpl().longestPalindrome(string);
        assertEquals(expected,actual);
    }

    @Test
    public void longestPalindromeTest4(){
        String expected = "zzzzzzzzzzzzzzzzzzzz";

        String string = "abcdefgfedcbazzzzzzzzzzzzzzzzzzzz";
        String actual = new LongestPalindromicSubstringImpl().longestPalindrome(string);
        assertEquals(expected,actual);
    }


    @Test
    public void longestPalindromeTest5(){
        String expected = "zz2345abbbba5432zz";

        String string = "zzzzzzz2345abbbba5432zzbbababa";
        String actual = new LongestPalindromicSubstringImpl().longestPalindrome(string);
        assertEquals(expected,actual);
    }
}