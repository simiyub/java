import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validatebst.ValidateBST;
import validatebst.ValidateBSTRecursiveImpl;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBSTTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void isValid() {
        ValidateBST.BST bst = new ValidateBST.BST(10);
        int[] values = new int[]{5,15,2,5,13,22,1,14};
        Arrays.stream(values).forEach(bst::insert);
        assertTrue(new ValidateBSTRecursiveImpl().isValid(bst));
    }

    @Test
    void isValid2() {
        ValidateBST.BST bst = new ValidateBST.BST(10);
        int[] values = new int[]{10,15,5,10};
        Arrays.stream(values).forEach(bst::insert);
        assertTrue(new ValidateBSTRecursiveImpl().isValid(bst));
    }
}