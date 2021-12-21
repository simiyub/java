package heightbalancedbinarytree;

/**
 * This function checks the binary tree provided to determine if it is height
 * balanced or not. A tree is balanced if it has equal number of children
 * on the left as on the right or at most one more on either side.
 * */
public interface HeightBalancedBinaryTree {

    boolean isBalanced(BinaryTree tree);


     class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

     }

    class BalancedStatus{

         boolean isBalanced;
         int height;

        public BalancedStatus(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }

    }



}
