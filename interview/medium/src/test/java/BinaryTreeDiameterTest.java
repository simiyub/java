import binarytreediameter.BinaryTreeDiameter;
import binarytreediameter.BinaryTreeDiameterImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeDiameterTest {

    @Test
    void diameterTest(){

        int expected = 5;
        BinaryTreeDiameter.BinaryTree tree = new BinaryTreeDiameter.BinaryTree(1);
        int[] array = new int[]{3,7,6,19,4,10,9,12};
        Arrays.stream(array).forEach(tree::insert);

        assertEquals(expected, new BinaryTreeDiameterImpl().diameter(tree));
    }

}