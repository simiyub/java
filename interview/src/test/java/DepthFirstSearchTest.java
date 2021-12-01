import depthfirstsearch.DepthFirstSearchImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BST;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public  void depthFirstSearchTest(){
        int[] list = new int[]{20,15,12,8,19,20,100,40,99,120};
        BST tree = new BST();
        Arrays.stream(list).forEach(tree::add);
        assertEquals(List.of(20,15,12,8,19,20,100,40,99,120), new DepthFirstSearchImpl().list(tree));
    }
}