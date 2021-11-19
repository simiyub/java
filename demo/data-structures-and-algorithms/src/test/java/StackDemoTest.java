import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackDemoTest {

    StackDemo stackDemo;

    @BeforeEach
    void setUp() {
        stackDemo = new StackDemo(10);
    }

    @AfterEach
    void tearDown() {
        stackDemo = null;
    }

    @Test
    void push() {

        assertNotNull(stackDemo.push(5));
    }

    @Test
    void pop() {
        stackDemo.push(5);
        assertNotNull(stackDemo.pop());
    }

    @Test
    void peek() {
        stackDemo.push(5);
        assertEquals(5, stackDemo.peek());
    }

    @Test
    void size() {
        stackDemo.push(5);
        assertEquals(1,  stackDemo.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stackDemo.isEmpty());
        stackDemo.push("something");
        assertFalse(stackDemo.isEmpty());
    }

    @Test
    void isFull() {
        stackDemo = new StackDemo(2);
        assertFalse(stackDemo.isFull());
        stackDemo.push(1);
        stackDemo.push(2);
        assertTrue(stackDemo.isFull());
    }

    @Test
    void ensureCapacity() {
        stackDemo = new StackDemo(3);
        assertFalse(stackDemo.isFull());
        stackDemo.push(1);
        stackDemo.push(2);
        stackDemo.push(3);
        assertEquals(6, stackDemo.ensureCapacity());
    }
}