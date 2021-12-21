/**
 *
 * O(n) T O(d) S
 * This function works by walking through the tree
 * and tracking the depth of the each branch of the tree's left and right branches.
 * Every time we get to the base case where there's no left or right child,
 * we take a difference between the highest value of each and current value and
 * pick the max of the two.
 * We do this throughout the tree until we get to the end of the tree and
 * have the longest of the diameters.
 * */
public interface BinaryTreeDiameter {
    int diameter(BinaryTree tree);

    class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree insert(int value){
            BinaryTree currentNode = this;
            while(true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BinaryTree(value);
                        break;
                    }
                    else currentNode = currentNode.left;
                }
                else{
                    if(currentNode.right == null) {
                        currentNode.right = new BinaryTree(value);
                        break;
                    }
                    else currentNode = currentNode.right;
                }
            }
            return this;
        }


    }
    class TreeTraversalStatus{
        public int diameter;
        public int height;

        public TreeTraversalStatus(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
