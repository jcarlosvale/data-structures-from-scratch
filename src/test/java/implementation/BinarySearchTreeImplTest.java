package implementation;

import jdk.nashorn.internal.ir.annotations.Ignore;
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

    @Test
    public void printTreeTwo() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(6);
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);
        binarySearchTree.print();
    }

    @Test
    public void printTreeThree() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(15);
        binarySearchTree.insert(6);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(18);
        binarySearchTree.insert(17);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(13);
        binarySearchTree.insert(20);
        binarySearchTree.insert(9);
        binarySearchTree.print();

        System.out.println("SEARCH: " + binarySearchTree.search(13));

        System.out.println("MAX: " + binarySearchTree.maximum());

        System.out.println("SUCC: " + binarySearchTree.successor(15));

        System.out.println("SUCC: " + binarySearchTree.successor(13));
    }

    @Test
    public void deleteCaseOneAndTwo() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(12);
        binarySearchTree.insert(5);
        binarySearchTree.insert(18);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(15);
        binarySearchTree.insert(13);
        binarySearchTree.insert(17);
        binarySearchTree.insert(19);
        binarySearchTree.print();

        System.out.println("DELETE 17");
        binarySearchTree.delete(17);
        binarySearchTree.print();

        System.out.println("DELETE 15");
        binarySearchTree.delete(15);
        binarySearchTree.print();
    }

    @Test
    public void deleteCaseThree() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(5);
        binarySearchTree.insert(8);
        binarySearchTree.print();

        System.out.println("DELETE 6");
        binarySearchTree.delete(6);
        binarySearchTree.print();
    }

    @Test
    public void deleteCaseFour() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(5);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(8);
        binarySearchTree.print();

        System.out.println("DELETE 6");
        binarySearchTree.delete(6);
        binarySearchTree.print();
    }

    @Test
    public void printTest() {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);

        binarySearchTree.insert(5);
        binarySearchTree.insert(7);

        binarySearchTree.print();
    }
}
