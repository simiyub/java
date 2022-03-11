import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListDemoTest {
    List<String> list;
    ListDemoImpl listDemo;
    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        listDemo = new ListDemoImpl(list);

    }

    @Test
    void unmodifiableList() {
    }

    @Test
    void addAll() {
    }

    @Test
    void replaceAll() {
    }

    @Test
    void sort() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void add() {
        String entry = "something";
        assertTrue(listDemo.add(entry));
    }

    @Test
    void remove() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void subList() {
    }

    @Test
    void of() {
    }

    @Test
    void copyOf() {
    }
}