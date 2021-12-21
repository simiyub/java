import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSuccessorTest {

    @Test
    void testSuccessor(){
        int expected = 0;
        FindSuccessor.BinaryTree tree = new FindSuccessor.BinaryTree(3);
        assertEquals(expected, new FindSuccessorImpl().successor(tree,tree));
    }

}