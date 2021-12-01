import util.BST;
import util.Node;

import java.util.Arrays;

/**
 * Go through the array and add up the execution times of previous functions
 * to determine the waiting time of current function.
 * */

public class MinimumWaitingTimeImpl implements MinimumWaitingTime{
    @Override
    public int minimumWaitingTime(int[] listOfFunctionExecutionTimes) {
        BST tree = new BST();
        Arrays.stream(listOfFunctionExecutionTimes).forEach(tree::add);
        return recursivelyCalculateMinimumWaitingTime(tree.getRoot(), 0);
    }

    private int recursivelyCalculateMinimumWaitingTime(Node node, int executionTime) {
    if(node!=null){
        executionTime += node.getValue();
        recursivelyCalculateMinimumWaitingTime(node.getLeft(), executionTime);
        recursivelyCalculateMinimumWaitingTime(node.getRight(), executionTime);
    }
    return executionTime;
    }
}
