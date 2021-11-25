public interface ClosestValueInBST {

    int closest(BST tree, int target);

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
