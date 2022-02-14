import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    void testNextNum(){

        int expected=3;
        assertEquals(expected,new RandomNumberGeneratorImpl().nextNum());

    }



}