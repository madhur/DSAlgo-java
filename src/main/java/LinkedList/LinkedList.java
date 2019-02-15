package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++this.sizeOfList;

        if (root == null) {
            this.root = new Node<>(data);
        } else {
            insertDataAtBeginning(data);
        }
    }

    // O(1)
    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;

    }

    // O(N)
    private void insertDataAtEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertDataAtEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {

        if (this.root == null) {
            return;
        }

        --this.sizeOfList;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }


    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {

        if (this.root == null) {
            return;
        }

        Node<T> actualNode = this.root;

        while (actualNode != null) {
            System.out.print(actualNode+ " -> ");
            actualNode = actualNode.getNextNode();
        }

    }

    @Override
    public int size() {
        return this.sizeOfList;
    }

    @Override
    public void reverse() {
       Node<T> prev = null;
       Node<T> curr = root;
       Node<T> next = null;

       while (curr != null) {
           next = curr.getNextNode();
           curr.setNextNode(prev);
           prev = curr;
           curr = next;

       }

       root = prev;
    }

    @Override
    public void removeDuplicates() {
        Set<Node> nodeSet = new HashSet<>();
        Node<T> previousNode = null;

        if (this.root == null) {
            return;
        }

        Node<T> actualNode = this.root;

        while (actualNode != null) {
            if (!nodeSet.contains(actualNode)) {
                nodeSet.add(actualNode);
                previousNode = actualNode;
            }
            else {
                previousNode.setNextNode(actualNode.getNextNode());
            }
            actualNode = actualNode.getNextNode();

        }

    }


}
