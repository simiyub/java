import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidIPAddressTest {

    @Test
    void validIPAddresses() {

        String[] expected = new String[]{
                "1.9.216.80",
                "1.92.16.80",
                "1.92.168.0",
                "19.2.16,80",
                "19.2.168.0",
                "19.21.6.80",
                "19.21.68.0",
                "19.216.8.0",
                "192.1.68.0",
                "192.1.6.80",
                "192.16.8.0"
        };
        String[] actual = new ValidIPAddressImpl().validIPAddresses("1921680");
        assertArrayEquals(expected,actual);
    }
}