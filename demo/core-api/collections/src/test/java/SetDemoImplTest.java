import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SetDemoImplTest {
    SetDemo setDemo;

    @BeforeEach
    void setUp() {
        setDemo = new SetDemoImpl(new HashSet<Integer>());
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void iterator() {
    }

    @Test
    void forEach() {
    }

    @Test
    void toArray() {
    }

    @Test
    void add() {

        assertTrue(setDemo.add(5));
    }

    @Test
    void remove() {
    }

    @Test
    void addAll() {
    }

    @Test
    void removeIf() {
    }

    @Test
    void clear() {
    }

    @Test
    void spliterator() {
    }

    @Test
    void stream() {
    }

    @Test
    void parallelStream() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void testToArray() {
    }
}