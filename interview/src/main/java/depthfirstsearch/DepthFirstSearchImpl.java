package depthfirstsearch;



import util.Node;
import util.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * O( vertices + edges) T and O(v) S as we call the function iteratively in each node and its children.
 * As we are using recursion we, each call is on the stack until we write to the array.
 * How it works
 * ------------
 * We add the first node onto the array provided and subsequently call the function with the children of the node.
 * */
public class DepthFirstSearchImpl implements DepthFirstSearch{

    @Override
    public List<Integer> list(BST tree) {

        return listRecursively(tree.getRoot(), new ArrayList<>());
    }

    private List<Integer> listRecursively(Node node, ArrayList<Integer> nodeNames) {
        if (node != null) {
            nodeNames.add(node.getValue());
            listRecursively(node.getLeft(), nodeNames);
            listRecursively(node.getRight(), nodeNames);
        }
        return nodeNames;
    }
}

