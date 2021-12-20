
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reconstructbst.ReconstructBST;
import reconstructbst.ReconstructBSTImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructBSTTest {

    ReconstructBST.BST expected;
    List<Integer> array;

    @BeforeEach
    void setUp() {
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

        expected = new ReconstructBST.BST(10);
        expected.left = four;
        expected.right = seventeen;
        array = List.of(10,4,2,1,5,17,19,18);
    }
    private void runTests(ReconstructBST impl){
        ReconstructBST.BST actual = impl.constructTree(array);
        assertEquals(expected.value,actual.value );
        assertEquals(expected.left.value,actual.left.value );
        assertEquals(expected.right.value,actual.right.value );
    }

    @Test
    void constructTreeBasicImplTest() {
        runTests(new ReconstructBSTImpl());
    }

//    @Test
//    void constructTreeFasterImplTest() {
//        runTests(new reconstructbst.ReconstructBSTFasterImpl());
//    }
}