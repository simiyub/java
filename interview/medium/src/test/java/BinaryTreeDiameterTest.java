import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeDiameterTest {

    @Test
    void diameterTest(){

        int expected = 6;
        BinaryTreeDiameter.BinaryTree tree = new BinaryTreeDiameter.BinaryTree(1);
        int[] array = new int[]{3,7,8,9,4,5,6,2};
        Arrays.stream(array).forEach(tree::insert);

        assertEquals(expected, new BinaryTreeDiameterImpl().diameter(tree));
    }

}