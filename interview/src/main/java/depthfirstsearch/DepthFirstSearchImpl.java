import util.BST;
import util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * O( vertices + edges) T and O(v) S
 * */
public class DepthFirstSearchImpl implements DepthFirstSearch {

    @Override
    public List<Integer> list(BST tree) {
        return listRecursively(tree.getRoot(), new ArrayList<Integer>());
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

