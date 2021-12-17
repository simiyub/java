import findkthlargestvalue.FindKthLargestValueInBST;
import findkthlargestvalue.FindKthLargestValueInBSTImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKthLargestValueInBSTTest {

    @Test
    void kthLargestValue() {
        int expected = 17;

        FindKthLargestValueInBST.BST one = new FindKthLargestValueInBST.BST(1);
        FindKthLargestValueInBST.BST three = new FindKthLargestValueInBST.BST(3);
        FindKthLargestValueInBST.BST two = new FindKthLargestValueInBST.BST(2);
        FindKthLargestValueInBST.BST five1 = new FindKthLargestValueInBST.BST(5);
        FindKthLargestValueInBST.BST five2 = new FindKthLargestValueInBST.BST(5);
        FindKthLargestValueInBST.BST seventeen = new FindKthLargestValueInBST.BST(17);
        FindKthLargestValueInBST.BST twentyTwo = new FindKthLargestValueInBST.BST(22);
        FindKthLargestValueInBST.BST twenty = new FindKthLargestValueInBST.BST(20);
        FindKthLargestValueInBST.BST bst = new FindKthLargestValueInBST.BST(15);
        two.left = one;
        two.right = three;
        five1.left = two;
        five1.right = five2;

        bst.left = five1;
        twenty.left = seventeen;
        twenty.right = twentyTwo;
        bst.right = twenty;

        assertEquals(expected, new FindKthLargestValueInBSTImpl().kthLargestValue(bst,3));
    }
}