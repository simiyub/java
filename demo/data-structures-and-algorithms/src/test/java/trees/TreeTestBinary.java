//package trees;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TreeTestBinary {
//    BinaryTree binaryTree, traversingBinaryTree;
//
//    @BeforeEach
//    void setUp() {
//        binaryTree = new BinaryTree();
//        traversingBinaryTree = new BinaryTree();
//    }
//
//    @AfterEach
//    void tearDown() {
//        binaryTree = null;
//    }
//
//    @Test
//    void insert() {
//        int value = 2;
//        assertEquals(value,binaryTree.insert(value).data);
//        int another = 3;
//        assertEquals(another,binaryTree.insert(another).data);
//        binaryTree.traverse();
//    }
//
//    @Test
//    void searchInOrder() {
//        int value3 = 3;
//        binaryTree.insert(value3);
//        assertEquals(value3, binaryTree.search(value3).data);
//        int value5 = 5;
//        binaryTree.insert(value5);
//        assertEquals(value5, binaryTree.search(value5).data);
//        binaryTree.insert(4);
//        binaryTree.insert(10);
//        binaryTree.insert(15);
//        binaryTree.insert(0);
//        binaryTree.traverse();
//    }
//
//    @Test
//    void searchPreOrder() {
//        int value3 = 3;
//        binaryTree.insert(value3);
//        assertEquals(value3, binaryTree.search(value3).data);
//        int value5 = 5;
//        binaryTree.insert(value5);
//        assertEquals(value5, binaryTree.search(value5).data);
//        binaryTree.insert(4);
//        binaryTree.insert(10);
//        binaryTree.insert(15);
//        binaryTree.insert(0);
//        binaryTree.traversePreOrder();
//    }
//
//    @Test
//    void searchPostOrder() {
//        int value3 = 3;
//        binaryTree.insert(value3);
//        assertEquals(value3, binaryTree.search(value3).data);
//        int value5 = 5;
//        binaryTree.insert(value5);
//        assertEquals(value5, binaryTree.search(value5).data);
//        binaryTree.insert(4);
//        binaryTree.insert(10);
//        binaryTree.insert(15);
//        binaryTree.insert(0);
//        binaryTree.traversePostOrder();
//    }
//
//}