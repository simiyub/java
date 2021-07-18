package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysAndStringsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void containsUniqueCharactersASCIIAndUnicode() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.containsUniqueCharactersASCIIAndUnicode("str"));
        assertFalse(arraysAndStrings.containsUniqueCharactersASCIIAndUnicode("strings"));
        assertFalse(arraysAndStrings.containsUniqueCharactersASCIIAndUnicode("str white space with dup"));
        assertTrue(arraysAndStrings.containsUniqueCharactersASCIIAndUnicode("space uniq"));
        assertThrows(RuntimeException.class,
                () ->arraysAndStrings.containsUniqueCharactersASCIIAndUnicode(" \uD83E\uDD2B"));
    }
}