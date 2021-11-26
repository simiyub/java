public class BinaryTree {
    private BST root;


    class BST {
         int value;
         BST left;
         BST right;

        public BST(int value) {
            this.value = value;
        }


    }

    private BST add(BST bst, int newValue) {

        if (bst == null) return new BST(newValue);
        if(newValue <= bst.value) bst.left = add(bst.left, newValue);
        if(newValue > bst.value) bst.right = add(bst.right,newValue);
        //  if(bst.left == null && bst.right == null) bst.value =newValue;

        //if(value < value) add(left,value);
        return bst;
    }

    public BST add(int value){
        if (root == null) {
            root = new BST(value);
            return root;
        }
        return add(root,value);
    }

    public BST getRoot() {
        return root;
    }
}
