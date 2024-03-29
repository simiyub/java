import minheightbst.MinHeightBST;
import minheightbst.MinHeightImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeightBSTTest {



    @Test
    void minHeightBSTTest(){
        MinHeightBST.BST seven = new MinHeightBST.BST(7);
        MinHeightBST.BST twentyTwo = new MinHeightBST.BST(22);
        MinHeightBST.BST thirteen = new MinHeightBST.BST(13);
        MinHeightBST.BST five = new MinHeightBST.BST(5);
        MinHeightBST.BST one = new MinHeightBST.BST(1);
        MinHeightBST.BST fifteen = new MinHeightBST.BST(15);
        MinHeightBST.BST two = new MinHeightBST.BST(2);
        MinHeightBST.BST fourteen = new MinHeightBST.BST(14);
        five.right = seven;
        thirteen.right = twentyTwo;
        two.left = one;
        two.right = five;
        fourteen.left = thirteen;
        fourteen.right = fifteen;

        MinHeightBST.BST expected  = new MinHeightBST.BST(10);
        expected.left = two;
        expected.right = fourteen;

        List<Integer> array = List.of( 1,2,5,7,10, 13,14,15,22);
        MinHeightBST.BST actual = new MinHeightImpl().minHeightBST(array);
        assertEquals(expected.value, actual.value);
        assertEquals(expected.left.value, actual.left.value);
        assertEquals(expected.right.value, actual.right.value);
    }

}