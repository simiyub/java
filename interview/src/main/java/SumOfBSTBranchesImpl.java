import util.BST;
import util.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class
SumOfBSTBranchesImpl implements SumOfBSTBranches {

    private static int nodeValue(Node node, int sum){
        if(node.getLeft()!=null) sum += nodeValue(node.getLeft(),sum);
        if(node.getRight()!=null) sum += nodeValue(node.getRight(),sum);
        return sum;
        }

    @Override
    public int[] sumOfBranches(BST tree) {
        List<Integer> sum = new ArrayList<>();
        Node currentNode = tree.getRoot();
        while (currentNode!=null){

            sum.add(nodeValue(currentNode, currentNode.getValue()));
        }
        int[] sumArray = new int[sum.size()];
        for(int i=0;i<sum.size();i++) sumArray[i] =sum.get(i);
        return sumArray;
    }
}
