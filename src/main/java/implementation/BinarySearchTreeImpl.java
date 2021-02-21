package implementation;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class BinarySearchTreeImpl {

    private static final int SIZE_NUMBER = 5;
    private Node root;
    
    public BinarySearchTreeImpl(Node root) {
        this.root = root;
    }

    public BinarySearchTreeImpl(int key) {
        this(new Node(key));
    }

    public Node search(int key) {
        return recursiveSearch(this.root, key);
    }

    private Node recursiveSearch(Node rootNode, int key) {
        if ((rootNode == null) || (key == rootNode.getKey())) {
            return rootNode;
        } else {
            if (key < rootNode.getKey()) {
                return recursiveSearch(rootNode.getLeft(), key);
            } else {
                return recursiveSearch(rootNode.getRight(), key);
            }
        }
    }

    public Node iterativeSearch(int key) {
        Node currentNode = root;
        while ((currentNode != null) && (currentNode.getKey() != key)) {
            if (key < currentNode.getKey()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return currentNode;
    }

    public void insert(Node newNode) {
        Node parentNode = null;
        Node currentNode = this.root;
        while (currentNode != null) {
            parentNode = currentNode;
            if (newNode.getKey() < currentNode.getKey()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        newNode.setParent(parentNode);
        if (parentNode == null) {
            this.root = newNode;
        } else {
            if (newNode.getKey() < parentNode.getKey()) {
                parentNode.setLeft(newNode);
            } else {
                parentNode.setRight(newNode);
            }
        }
    }

    private void transplant(Node node1, Node node2) {
        if (node1.getParent() == null) {
            this.root = node2;
        } else {
            if (node1 == node1.getParent().getLeft()) {
                node1.getParent().setLeft(node2);
            } else {
                node1.getParent().setRight(node2);
            }
        }
        if (node2 != null) {
            node2.setParent(node1.getParent());
        }
    }

    private void delete(Node nodeToDelete) {
        if (nodeToDelete.getLeft() == null) {
            transplant(nodeToDelete, nodeToDelete.getRight());
        } else {
            if (nodeToDelete.getRight() == null) {
                transplant(nodeToDelete, nodeToDelete.getLeft());
            }
            else {
                Node minimumNode = nodeToDelete.getRight().minimum();
                if (minimumNode.getParent() != nodeToDelete) {
                    transplant(minimumNode, minimumNode.getRight());
                    minimumNode.setRight(nodeToDelete.getRight());
                    minimumNode.getRight().setParent(minimumNode);
                }
                transplant(nodeToDelete, minimumNode);
                minimumNode.setLeft(nodeToDelete.getLeft());
                minimumNode.getLeft().setParent(minimumNode);
            }
        }
    }

    public void insert(int key) {
        this.insert(new Node(key));
    }

    public int maxLevel() {
        return maxLevel(root);
    }

    private int maxLevel(Node node) {
        if (node == null) return 0;
        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    public void print() {
        int maxLevel = maxLevel();

        System.out.println("INTERNAL METHOD");
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        System.out.println("OWN METHOD");
        print(Collections.singletonList(root), 1, maxLevel);

    }

    private void print(List<Node> nodes, int level, int maxLevel) {
        if(maxLevel < level) return;
        int total = (int) Math.pow(2, maxLevel) - 1;
        int spaceInterval = total / (int) Math.pow(2, level);
        spaceInterval = spaceInterval * SIZE_NUMBER;
        List<Node> newNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (i == 0) {
                printWhitespaces(spaceInterval);
            } else {
                printWhitespaces(spaceInterval);
                printWhitespaces(SIZE_NUMBER);
                printWhitespaces(spaceInterval);
            }
            if(node != null) {
                printNode(node);
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else{
                printWhitespaces(SIZE_NUMBER);
                //System.out.print(" NULL");
                newNodes.add(null);
                newNodes.add(null);
            }
        }
        System.out.println();
        level++;
        print(newNodes, level, maxLevel);
    }

    private void printNode(Node node) {
        System.out.printf("%1$5s", node.getKey());
    }

    //https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
    private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.getKey());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private boolean isAllElementsNull(List<Node> nodes) {
        for (Node node : nodes) {
            if (node != null)
                return false;
        }
        return true;
    }

    public Node maximum() {
        return this.root.maximum();
    }

    public Node successor(int key) {
        Node node = search(key);
        if (node != null) {
            return node.successor();
        } else {
            return null;
        }
    }

    public void delete(int key) {
        Node node = search(key);
        if (node != null) {
            delete(node);
        }
    }
}
