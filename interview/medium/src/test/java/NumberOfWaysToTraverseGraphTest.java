import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToTraverseGraphTest {

    @Test
    void testNumberOfWaysToTraverseGraph1(){

        int expected = 10;
        int width=4;
        int height=3;
        assertEquals(expected, new NumberOfWaysToTraverseGraphImpl().count(width, height));
    }

    @Test
    void testNumberOfWaysToTraverseGraph2(){

        int expected = 210;
        int width=5;
        int height=7;
        assertEquals(expected, new NumberOfWaysToTraverseGraphFactorialImpl().count(width, height));
    }

}