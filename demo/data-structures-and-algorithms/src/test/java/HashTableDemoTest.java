import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableDemoTest {
    HashTableDemo demo;

    @BeforeEach
    void setUp() {
        demo = new HashTableDemo(10);

    }

    @AfterEach
    void tearDown() {
        demo = null;
    }

    @Test
    void put() {
        String keyOne = "one";
        int one = 1;
        demo.put(keyOne,one);
        int receivedOne = (int)demo.get(keyOne);
        System.out.println(receivedOne);
        assertEquals(one,demo.get(keyOne));

        String keyTwo = "two";
        int two = 2;
        demo.put(keyTwo,two);
        int receivedTwo = (int)demo.get(keyTwo);
        System.out.println(receivedTwo);
        assertEquals(two,receivedTwo);
    }

    @Test
    void get() {
    }
}