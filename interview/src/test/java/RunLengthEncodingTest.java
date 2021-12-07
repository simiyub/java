import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunLengthEncodingTest {

    @Test
    void encode() {
        String expected = "9A4A2B4C2D";
        String string = "AAAAAAAAAAAAABBCCCCDD";
        assertEquals(expected, new RunLengthEncodingImpl().encode(string));
    }
}