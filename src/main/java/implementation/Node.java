package implementation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int key;
    private Node right;
    private Node left;
    private Node parent;

    public Node(int key) {
        this.key = key;
    }

    public Node minimum() {
        Node currentNode = this;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    public Node maximum() {
        Node currentNode = this;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    public Node successor() {
        Node currentNode = this;
        if (this.getRight() != null) {
            return this.getRight().minimum();
        }
        Node parentNode = this.getParent();
        while ((parentNode != null) && (currentNode == parentNode.getRight())) {
            currentNode = parentNode;
            parentNode = parentNode.getParent();
        }
        return parentNode;
    }
}
