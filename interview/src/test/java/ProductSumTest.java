import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsum.ProductSumImpl;

import static org.junit.jupiter.api.Assertions.*;

class ProductSumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void productSum() {

        Object[] array =new Object[]{5,2,new Object[]{7,-1},3,new Object[]{6, new Object[]{-13,8},4}};
        assertEquals(12,new ProductSumImpl().productSum(array));
    }
}