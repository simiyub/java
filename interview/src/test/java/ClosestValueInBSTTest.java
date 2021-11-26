import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestValueInBSTTest {

    private int expectedValueClosestIsSmaller;
    private int targetValueClosestIsSmaller;
    private int[] valuesClosestIsSmaller;
    private int expectedValueClosestIsLarger;
    private int targetValueClosestIsLarger;
    private int[] valuesClosestIsLarger;
    @BeforeEach
    void setUp() {
        expectedValueClosestIsSmaller =3;
        targetValueClosestIsSmaller = 5;
        valuesClosestIsSmaller = new int[]{2,3};
        expectedValueClosestIsLarger = 17;
        targetValueClosestIsLarger = 19;
        valuesClosestIsLarger = new int[]{2,3,12,1, 15, 17, 22};

    }

    private void runTest(ClosestValueInBST impl){

        BinaryTree smallTree = new BinaryTree();

        for (int i=0;i<=  valuesClosestIsSmaller.length-1;i++){
            smallTree.add(valuesClosestIsSmaller[i]);
        }
        assertEquals(expectedValueClosestIsSmaller, impl.closest(smallTree.getRoot(),targetValueClosestIsSmaller));


        BinaryTree largeTree = new BinaryTree();
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