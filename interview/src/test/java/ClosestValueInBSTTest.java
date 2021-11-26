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

    @Test
    void addSmaller(){
        BinaryTree tree = new BinaryTree();
        int[] values = new int[]{5,3,2, 7};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(2, tree.getRoot().left.left.value);
    }

    @Test
    void addLarger(){
        BinaryTree tree = new BinaryTree();
        int[] values = new int[]{5,7, 9};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(9, tree.getRoot().right.right.value);
    }

    @Test
    void addLargerAndSmaller(){
        BinaryTree tree = new BinaryTree();
        int[] values = new int[]{5,7,9, 8};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(8, tree.getRoot().right.right.left.value);
    }

    @Test
    void addEqual(){
        BinaryTree tree = new BinaryTree();
        int[] values = new int[]{5,7,7,9, 8};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(7, tree.getRoot().right.left.value);
    }
}