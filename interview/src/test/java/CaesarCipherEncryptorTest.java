import caesarcipherencryptor.CaesarCipherEncryptorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherEncryptorTest {

    @Test
    void encrypt1() {
        String expected = "zab";
        assertEquals(expected, new CaesarCipherEncryptorImpl().encrypt("xyz", 2));
    }

    @Test
    void encrypt2() {
        String expected = "abc";
        assertEquals(expected, new CaesarCipherEncryptorImpl().encrypt("abc", 52));
    }
}
