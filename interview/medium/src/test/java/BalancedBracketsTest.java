import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsTest {

    @Test
    void balanced1() {
        String string = "([])(){}(())()()";
        assertTrue(new BalancedBracketsImpl().balanced(string));
    }

    @Test
    void balanced2() {
        String string = "([])(){}(()()()";
        assertFalse(new BalancedBracketsImpl().balanced(string));
    }

    @Test
    void balanced3() {
        String string = ")[]}";
        assertFalse(new BalancedBracketsImpl().balanced(string));
    }
}