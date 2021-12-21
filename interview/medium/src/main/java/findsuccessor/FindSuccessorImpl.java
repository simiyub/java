package findsuccessor;

/**
 * O(h) T on average and O(1) S but could go to O(n) T if the tree only has one sided branch
 * such as only left children or only right children.
 * This function uses the logic explained in the algoexpert.io solution of the find successor.
 * The successor of the node will be the most left child of the node's right branch or it's ancestor if there
 *  is no left node.
 *  So we traverse the tree and if there is a right branch, we find the most left
 *  node of the right branch. If it doesn't exist, then we find the ancestor of the node.
 * */

public class FindSuccessorImpl implements FindSuccessor{
    @Override
    public BinaryTree successor(BinaryTree tree, BinaryTree node) {
        if (tree!=null){
            if(node.right!=null) return mostLeftChild(node.right);
            return ancestor(node);
        }
        return null;
    }

    private BinaryTree ancestor(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.parent!=null && currentNode.parent.right==currentNode) currentNode = currentNode.parent;
        return currentNode.parent;
    }

    private BinaryTree mostLeftChild(BinaryTree node) {
        BinaryTree currentNode=node;
        while(currentNode.left!=null) currentNode = currentNode.left;
        return currentNode;
    }
}
