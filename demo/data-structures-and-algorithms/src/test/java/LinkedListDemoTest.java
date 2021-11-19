import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListDemoTest {

    int[] data;
    LinkedListDemo linkedListDemo;
    @BeforeEach
    void setUp() {
        data = new int[5];
        data[0] = 1;
        data[1] = 2;
        data[2] = 3;
        data[3] = 4;
        linkedListDemo = new LinkedListDemo();
    }

    @AfterEach
    void tearDown() {
        data = null;
    }

    @Test
    void append() {


        for(int i=0;i<data.length;i++){
            linkedListDemo.append(data[i]);
        };
       assertArrayEquals(data, linkedListDemo.data());
        };



    @Test
    void prepend() {

        for(int i=0;i<data.length;i++){
            linkedListDemo.append(data[i]);
        };

        int six = 6;
        linkedListDemo.prepend(six);
        assertEquals(six, linkedListDemo.data()[0]);
    }

    @Test
    void deleteWithValue() {

        for(int i=0; i<data.length; i++){
            linkedListDemo.append(data[i]);
        }
        assertTrue(linkedListDemo.deleteWithValue(4));
    }
}