import java.util.List;

/**
 * This function will receive an array that is in the order of a preorder traversal tree.
 * It will then construct a tree using the preorder traversal.
 * */
public interface ReconstructBST {
    BST constructTree(List<Integer> array);

 class BST {
     public int value;
     public BST left = null;
     public BST right = null;

     public BST(int value) {
         this.value = value;
     }
 }
}
