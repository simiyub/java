import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sumofbstbranches.SumOfBSTBranchesImpl;
import util.BST;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfBSTBranchesTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sumOfBranchesRoot() {
        int[] values = new int[]{1,2,4,8,9,5,10,3,6,7};

        BST tree = new BST();
        Arrays.stream(values).forEach(tree::add);
        List<Integer> expected =List.of(10,33,34);
        assertEquals(expected, new SumOfBSTBranchesImpl().sumOfBranches(tree));
    }

}