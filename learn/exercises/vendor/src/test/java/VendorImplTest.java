import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VendorImplTest {
    Vendor vendor;
    @BeforeEach
    void setUp() {
        vendor = new VendorImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void vend() {
        assertEquals(vendor.vend(1,1).getQuantity(),1);
        assertEquals(vendor.checkStock(1),0);

        assertEquals(vendor.vend(2,1).getQuantity(),1);
        assertEquals(vendor.checkStock(2),1);
    }

    @Test
    void checkStock() {
        assertEquals(vendor.checkStock(1),1);
    }
}