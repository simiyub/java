import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import removeduplicatesfromlinkedlist.RemoveDuplicateListImpl;
import removeduplicatesfromlinkedlist.RemoveDuplicatesFromLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromLinkedListTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void removeDuplicatesTest1() {
        RemoveDuplicatesFromLinkedList.LinkedListRecord four = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        RemoveDuplicatesFromLinkedList.LinkedListRecord twoDuplicate = new RemoveDuplicatesFromLinkedList.LinkedListRecord(2);
        RemoveDuplicatesFromLinkedList.LinkedListRecord three = new RemoveDuplicatesFromLinkedList.LinkedListRecord(3);
        RemoveDuplicatesFromLinkedList.LinkedListRecord two = new RemoveDuplicatesFromLinkedList.LinkedListRecord(2);
        RemoveDuplicatesFromLinkedList.LinkedListRecord one = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        one.next = two;
        two.next = twoDuplicate;
        twoDuplicate.next = three;
        three.next = four;

        RemoveDuplicatesFromLinkedList.LinkedListRecord expected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        RemoveDuplicatesFromLinkedList.LinkedListRecord twoExpected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(2);
        RemoveDuplicatesFromLinkedList.LinkedListRecord threeExpected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(3);
        RemoveDuplicatesFromLinkedList.LinkedListRecord fourExpected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        expected.next = twoExpected;
        twoExpected.next = threeExpected;
        threeExpected.next = fourExpected;
        assertEquals(expected, new RemoveDuplicateListImpl().removeDuplicates(one));
    }

    @Test
    void removeDuplicatesTest2() {
        RemoveDuplicatesFromLinkedList.LinkedListRecord six = new RemoveDuplicatesFromLinkedList.LinkedListRecord(6);
        RemoveDuplicatesFromLinkedList.LinkedListRecord sixDup1 = new RemoveDuplicatesFromLinkedList.LinkedListRecord(6);
        RemoveDuplicatesFromLinkedList.LinkedListRecord five = new RemoveDuplicatesFromLinkedList.LinkedListRecord(5);
        RemoveDuplicatesFromLinkedList.LinkedListRecord four = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        RemoveDuplicatesFromLinkedList.LinkedListRecord fourDup1 = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        RemoveDuplicatesFromLinkedList.LinkedListRecord fourDup2 = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        RemoveDuplicatesFromLinkedList.LinkedListRecord fourDup3 = new RemoveDuplicatesFromLinkedList.LinkedListRecord(4);
        RemoveDuplicatesFromLinkedList.LinkedListRecord three = new RemoveDuplicatesFromLinkedList.LinkedListRecord(3);
        RemoveDuplicatesFromLinkedList.LinkedListRecord oneDup2 = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        RemoveDuplicatesFromLinkedList.LinkedListRecord oneDup1 = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        RemoveDuplicatesFromLinkedList.LinkedListRecord one = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        one.next = oneDup1;
        oneDup1.next = oneDup2;
        oneDup2.next = three;
        three.next = four;
        four.next = fourDup1;
        fourDup1.next = fourDup2;
        fourDup2.next = fourDup3;
        fourDup3.next = five;
        five.next = six;
        six.next = sixDup1;

        RemoveDuplicatesFromLinkedList.LinkedListRecord expected = new RemoveDuplicatesFromLinkedList.LinkedListRecord(1);
        expected.next = oneDup1;
        RemoveDuplicatesFromLinkedList.LinkedListRecord response = new RemoveDuplicateListImpl().removeDuplicates(one);
        assertEquals(expected, response);
    }
}