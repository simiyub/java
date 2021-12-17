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
