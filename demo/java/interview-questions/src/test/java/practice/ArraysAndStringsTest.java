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

    @Test
    void containsUniqueCharactersa_z() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.containsUniqueCharactersa_z("str"));
        assertThrows(RuntimeException.class,
                () ->arraysAndStrings.containsUniqueCharactersa_z("string2"));
    }

    @Test
    void intToBinary(){
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        int number =  112;
      //  assertEquals(Integer.toBinaryString(number),arraysAndStrings.intToBinary(number,2));
        arraysAndStrings.intToBinary(10,2);
    }

    @Test
    void binaryToInt(){
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        String bin = "1100111";
        int radix = 2;
        assertEquals((64+32+4+2+1),arraysAndStrings.binaryToInt(bin, radix));
    }

    @Test
    void bitwiseUnary(){
       assertEquals(2,new ArraysAndStrings().bitwiseUnary(5));
    }
}