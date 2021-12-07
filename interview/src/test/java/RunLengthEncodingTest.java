import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunLengthEncodingTest {

    @Test
    void encode() {
        String expected = "9A4A2B4C1E2D";
        String string = "AAAAAAAAAAAAABBCCCCEDD";
        assertEquals(expected, new RunLengthEncodingImpl().encode(string));
    }
}