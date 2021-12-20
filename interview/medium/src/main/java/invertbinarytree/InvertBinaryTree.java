package invertbinarytree;

/**
 * This function takes a binary tree and inverts it's nodes
 * such that the nodes to the left are moved to the right and vice versa.
 * *******1**********************1***
 * ****2-----3****************3-----2***
 ****4--5**6---7* becomes***7---6*5---4****
 ***8-9*****************************8---9****
 * */
public interface InvertBinaryTree {
    BinaryTree invert(BinaryTree tree);

     class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }

    }
}
