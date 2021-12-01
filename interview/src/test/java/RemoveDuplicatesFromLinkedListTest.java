import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromLinkedListTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void removeDuplicates() {
        RemoveDuplicatesFromLinkedList.LinkedListRecord four = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        RemoveDuplicatesFromLinkedList.LinkedListRecord twoDuplicate = new RemoveDuplicatesFromLinkedList.LinkedListRecord(2);
        RemoveDuplicatesFromLinkedList.LinkedListRecord three = new RemoveDuplicatesFromLinkedList.LinkedListRecord(3);
        RemoveDuplicatesFromLinkedList.LinkedListRecord two = new RemoveDuplicatesFromLinkedList.LinkedListRecord(2);
        RemoveDuplicatesFromLinkedList.LinkedListRecord one = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        one.next = two;
        two.next = three;
        three.next = twoDuplicate;
        twoDuplicate.next = four;

        RemoveDuplicatesFromLinkedList.LinkedListRecord expected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        RemoveDuplicatesFromLinkedList.LinkedListRecord twoExpected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(2);
        RemoveDuplicatesFromLinkedList.LinkedListRecord threeExpected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(3);
        RemoveDuplicatesFromLinkedList.LinkedListRecord fourExpected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        expected.next = twoExpected;
        twoDuplicate.next = threeExpected;
        threeExpected.next = fourExpected;
        assertEquals(expected, new RemoveDuplicateListImpl().removeDuplicate(one));
    }
}