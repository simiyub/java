import arrayofproducts.ArrayOfProductsImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOfProductsTest {

    @Test
    void products() {
//        int[] expected = new int[]{105,175,105,75};
//        int[] array = new int[]{5,3,5,7};
        int[] array = new int[]{5,1,4,2};
        int[] expected =  new int[]{8,40,10,20};
        assertArrayEquals(expected,new ArrayOfProductsImpl().products(array));
    }
}