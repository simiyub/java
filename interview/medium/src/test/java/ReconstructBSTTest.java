
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructBSTTest {

    @Test
    void constructTree() {
        ReconstructBST.BST one = new ReconstructBST.BST(1);
        ReconstructBST.BST two = new ReconstructBST.BST(2);
        ReconstructBST.BST five = new ReconstructBST.BST(5);
        ReconstructBST.BST four = new ReconstructBST.BST(4);
        ReconstructBST.BST seventeen = new ReconstructBST.BST(17);
        ReconstructBST.BST nineteen = new ReconstructBST.BST(19);
        ReconstructBST.BST eighteen = new ReconstructBST.BST(18);
        two.left = one;
        four.left = two;
        four.right = five;
        nineteen.left = eighteen;
        seventeen.left = nineteen;

        ReconstructBST.BST expected = new ReconstructBST.BST(10);
        expected.left = four;
        expected.right = seventeen;
        List<Integer> array = List.of(10,4,2,1,5,17,19,18);
        ReconstructBST.BST actual = new ReconstructBSTImpl().constructTree(array);
        assertEquals(expected,actual );
                
    }
}