public class BinaryTree {
    private BST root;


    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }


    }

    private BST add(BST bst, int newValue) {
        if (bst == null) return new BST(newValue);
        //  if(bst.left == null && bst.right == null) bst.value =newValue;

        //if(value < value) add(left,value);
        return bst;
    }

    public BST add(int value){

        return add(root,value);
    }

}
