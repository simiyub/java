package validatebst;

/**
 * This function checks if a BST is valid meaning
 * for every node, the nodes to it's left have a value strictly less than its value
 * and the nodes to the right are strictly
 * */

public interface ValidateBST {
    boolean isValid(BST tree);

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
        public BST insert(int value){
            BST currentNode = this;
            while(true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    }
                    else currentNode = currentNode.left;
                }
                else{
                    if(currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    }
                    else currentNode = currentNode.right;
                }
            }
            return this;
        }
    }
}
