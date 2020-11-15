package implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTreeImplTest {

    @Test
    public void loadTreeTest() {
        Node node = new Node(1);
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl(node);
        System.out.println(tree);
    }

    @Test
    public void searchOneElement() {
        int key = 1;
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl(new Node(key));
        Node actualTree = tree.search(key);
        Assertions.assertNotNull(actualTree);
        Assertions.assertEquals(tree, actualTree);
    }

    @Test
    public void searchIteractiveOneElement() {
        int key = 1;
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl(new Node(key));
        Node actualTree = tree.iterativeSearch(key);
        Assertions.assertNotNull(actualTree);
        Assertions.assertEquals(tree, actualTree);
    }

    @Test
    public void searchOneElementNotFound() {
        int key = 1;
        int searchKey = 2;
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl(new Node(key));
        Node actualTree = tree.search(searchKey);
        Assertions.assertNull(actualTree);
    }

    @Test
    public void searchIterativeOneElementNotFound() {
        int key = 1;
        int searchKey = 2;
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl(new Node(key));
        Node actualTree = tree.iterativeSearch(searchKey);
        Assertions.assertNull(actualTree);
    }

    @Test
    public void printTreeOne() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(8);
        binarySearchTree.print();
    }


}
