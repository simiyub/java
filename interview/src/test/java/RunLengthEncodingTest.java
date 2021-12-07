import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunLengthEncodingTest {

    @Test
    void encodeTest1() {
        String expected = "9A4A2B4C1E2D";
        String string = "AAAAAAAAAAAAABBCCCCEDD";
        assertEquals(expected, new RunLengthEncodingImpl().encode(string));
    }

    @Test
    void encodeTest2() {
        String expected = "1 ";
        String string = " ";
        assertEquals(expected, new RunLengthEncodingImpl().encode(string));
    }

    @Test
    void encodeTest3() {
        String expected = "9A9A";
        String string = "AAAAAAAAAAAAAAAAAA";
        assertEquals(expected, new RunLengthEncodingImpl().encode(string));
    }

    @Test
    void encodeTest4() {
        String expected = "9;3;9'9'2'111273524142311s";
        String string = ";;;;;;;;;;;;''''''''''''''''''''1233333332222211112222111s";
        assertEquals(expected, new RunLengthEncodingImpl().encode(string));
    }
}