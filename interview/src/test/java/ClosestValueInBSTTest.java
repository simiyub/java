import util.BST;
import closetvalueinbst.ClosestValueInBST;
import closetvalueinbst.ClosestValueInBSTIterativeImpl;
import closetvalueinbst.ClosestValueInBSTRecursiveImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestValueInBSTTest {

    private int expectedValueClosestIsSmaller;
    private int targetValueClosestIsSmaller;
    private int[] valuesClosestIsSmaller;
    private int expectedValueClosestIsLarger;
    private int targetValueClosestIsLarger;

    @BeforeEach
    void setUp() {
        expectedValueClosestIsSmaller =3;
        targetValueClosestIsSmaller = 5;
        valuesClosestIsSmaller = new int[]{2,3};
        expectedValueClosestIsLarger = 17;
        targetValueClosestIsLarger = 19;

    }

    private void runTest(ClosestValueInBST impl){

        BST smallTree = new BST();

        for (int i=0;i<=  valuesClosestIsSmaller.length-1;i++){
            smallTree.add(valuesClosestIsSmaller[i]);
        }
        assertEquals(expectedValueClosestIsSmaller, impl.closest(smallTree.getRoot(),targetValueClosestIsSmaller));


        BST largeTree = new BST();
        int[] values = new int[]{2,3,12,1, 15, 17, 22};
        for (int i=0;i<=values.length-1;i++){
            largeTree.add(values[i]);
        }

        assertEquals(expectedValueClosestIsLarger, new ClosestValueInBSTRecursiveImpl().closest(largeTree.getRoot(),targetValueClosestIsLarger));
    }

    @Test
    void closestRecursive() {
        runTest(new ClosestValueInBSTRecursiveImpl());
    }

    @Test
    void closestIterative() {
        runTest(new ClosestValueInBSTIterativeImpl());
    }

    @Test
    void addRoot(){
        BST tree = new BST();
        assertEquals(5, tree.add(5).getValue());
    }

    @Test
    void addSmaller(){
        BST tree = new BST();
        int[] values = new int[]{5,3,2, 7};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(2, tree.getRoot().getLeft().getLeft().getValue());
    }

    @Test
    void addLarger(){
        BST tree = new BST();
        int[] values = new int[]{5,7, 9};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(9, tree.getRoot().getRight().getRight().getValue());
    }

    @Test
    void addLargerAndSmaller(){
        BST tree = new BST();
        int[] values = new int[]{5,7,9, 8};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(8, tree.getRoot().getRight().getRight().getLeft().getValue());
    }

    @Test
    void addEqual(){
        BST tree = new BST();
        int[] values = new int[]{5,7,7,9, 8};
        for (int i=0;i<=values.length-1;i++){
            tree.add(values[i]);
        }
        assertEquals(7, tree.getRoot().getRight().getLeft().getValue());
    }
}