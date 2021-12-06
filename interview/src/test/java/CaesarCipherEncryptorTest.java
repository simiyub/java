import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherEncryptorTest {

    @Test
    void encrypt() {
        String expected = "zab";
        assertEquals(expected, new CaesarCipherEncryptorImpl().encrypt("xyz", 2));
    }
}