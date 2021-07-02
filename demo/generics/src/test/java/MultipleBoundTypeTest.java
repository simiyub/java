import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleBoundTypeTest {

    @Test
    void printTypePrime(){
        ANumber aNumber =new ANumber(5);
        MultipleBoundType<ANumber> multipleBoundType
                = new MultipleBoundType<>(aNumber);
        assertEquals(aNumber,multipleBoundType.type());
        assertTrue(aNumber.divisible(aNumber.number));
        assertTrue(aNumber.prime(aNumber.number));
    }

    @Test
    void printTypeDivisible(){
        ANumber aNumber4 =new ANumber(4);
        MultipleBoundType<ANumber> multipleBoundType2
                = new MultipleBoundType<>(aNumber4);
        assertEquals(aNumber4,multipleBoundType2.type());
        assertTrue(aNumber4.divisible(aNumber4.number));
        assertFalse(aNumber4.prime(aNumber4.number));
    }

}