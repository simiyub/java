package sumofbstbranches;

import util.BST;
import util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * O(n) T O(n) space as we store the data in a list which could potentially go to n
 * This is a recursive implementation.
 * TODO: Can this be done using iteration?
 * */
public class SumOfBSTBranchesImpl implements SumOfBSTBranches {

    private static List<Integer> nodeValue(Node node, int sum,List<Integer> sums){
        if(node!=null) {
            sum += node.getValue();

            if (node.getLeft() == null && node.getRight() == null) sums.add(sum);
            else {
                nodeValue(node.getLeft(), sum, sums);
                nodeValue(node.getRight(), sum, sums);
            }
        }
        return sums;
        }

    @Override
    public List<Integer> sumOfBranches(BST tree) {
        List<Integer> sum = new ArrayList<>();
        return nodeValue(tree.getRoot(),0,sum);
    }
}
