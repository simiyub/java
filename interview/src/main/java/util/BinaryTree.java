package util;


public class BinaryTree {
    private BST root;

    private BST add(BST bst, int newValue) {

        if (bst == null) return new BST(newValue);
        if (newValue <= bst.value) bst.left = add(bst.left, newValue);
        if (newValue > bst.value) bst.right = add(bst.right, newValue);
        return bst;
    }

    public BST add(int value) {
        if (root == null) {
            root = new BST(value);
            return root;
        }
        return add(root, value);
    }

    public BST getRoot() {
        return root;
    }

    public static class BST {
        int value;
        BST left;
        BST right;

        public BST(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public BST getLeft() {
            return left;
        }

        public BST getRight() {
            return right;
        }


    }
}
