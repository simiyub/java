import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestValueInBSTTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void closest() {
//        int expectedValue =2;
//        BinaryTree tree = new BinaryTree()
//        ClosestValueInBST.BST bst=new ClosestValueInBST.BST(5);
//        b
//
//        assertEquals(expectedValue, new ClosestValueInBSTImpl().closest(bst,5));
    }

    @Test
    void addRoot(){
        BinaryTree tree = new BinaryTree();
        assertEquals(5, tree.add(5).value);
    }
}