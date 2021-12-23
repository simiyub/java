import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitManipulationTest {
    @Test
    void testValueOfKthBit(){

        char expected = '1';
        assertEquals(expected,new BitManipulationImpl().valueOfKthBit(423,7));
    }

}