import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildCardDemoTest {

    private WildCardDemo<Double> demo;

    private double testDemoDouble;

    @BeforeEach
    void setUp() {
        testDemoDouble = 5.0;
        demo = new WildCardDemo<>(testDemoDouble);
    }

    @Test
    void printType(){
        System.out.println(demo.printType());
        assertEquals(testDemoDouble,demo.printType());
    }

    @Test
    void genericFunction(){
        double number = 2.0;
        double result = demo.genericFunction(number);
        System.out.println(result);
        assertEquals(number, result);
    }
}