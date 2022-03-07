package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * **/
class ValidateSubSequenceTest {

    @Test
    void isSubSequence1() {
        assertTrue(new ValidateSubSequenceImpl().isSubSequence(new int[]{5, 1,22, 25, 6, -1, 8, 10}, new int[]{1,6,-1, 10}));
    }

    @Test
    void isSubSequence2() {
        assertTrue(new ValidateSubSequenceImpl().isSubSequence(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1}));
    }

    @Test
    void isSubSequence3() {
        assertTrue(new ValidateSubSequenceImpl().isSubSequence(new int[]{1, 2, 3, 4, 5, 3, 4, 5, 6}, new int[]{3, 4, 5, 6}));
    }
}