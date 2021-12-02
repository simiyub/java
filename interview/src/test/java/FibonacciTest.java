import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void fibonacciRecursive() {
        assertEquals(233,new FibonacciRecursiveImpl().fibonacci(14));
    }

    @Test
    void fibonacciRecursiveWithMemoization(){
        assertEquals(233, new FibonacciRecursiveWithMemoizationImpl().fibonacci(14));
    }

    @Test
    void fibonacciIterative(){
        assertEquals(233, new FibonacciIterativeImpl().fibonacci(14));
    }


}