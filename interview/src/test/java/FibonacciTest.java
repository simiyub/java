import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void fibonacci() {
        assertEquals(5,new FibonacciImpl().fibonacci(7));
    }
}