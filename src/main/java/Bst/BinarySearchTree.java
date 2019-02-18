package Bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> root;

    @Override
    public void insert(T data) {

        if (root == null) {
            root = new Node<>(data);
        } else {
            insertNode(data, root);
        }
    }

    @Override
    public void traversal() {

        if(root != null) {
            inOrderTraversal(this.root);
        }

    }

    private void inOrderTraversal(Node<T> node) {

        if(node.getLeft()!=null) {
            inOrderTraversal(node.getLeft());
        }

        System.out.print(node + " - ");

        if(node.getRight() != null) {
            inOrderTraversal(node.getRight());
        }

    }


    private void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {
            if ( node.getLeft() != null) {
                insertNode(newData, node.getLeft());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeft(newNode);
            }

        } else {
            if ( node.getRight() != null) {
                insertNode(newData, node.getRight());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRight(newNode);
            }
        }
    }

    @Override
    public void delete(T data) {


    }

    private Node<T> deleteNode(Node<T> node, T data) {
        if (node == null) return node;

        if(data.compareTo(node.getData()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(deleteNode(node.getRight(), data));
        } else {
            if(node.getLeft() == null && node.getRight() == null) {
                System.out.println("Removing a left node...");
                return null;
            }

            if (node.getLeft() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRight();
                node = null;
                return tempNode;
            } else if(node.getRight() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeft();
                node = null;
                return tempNode;
            }

            // this is the node with two children case !!!

            System.out.println("Removing item with two children...");
            Node<T> tempNode = getPredecessor(node.getLeft());

            node.setData(tempNode.getData());
            node.setLeft(deleteNode(node.getLeft(), tempNode.getData()));

        }


        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRight() != null)
            return getPredecessor(node.getRight());

        return node;
    }

    @Override
    public T getMax() {

        if (root == null) {
            return null;
        }

        return getMaxNode(this.root);

    }

    private T getMaxNode(Node<T> node) {

        if (node.getRight() != null) {

            return getMaxNode(node.getRight());
        }

        return node.getData();
    }

    @Override
    public T getMin() {

        if (root == null) {
            return null;
        }

        return getMinNode(this.root);
    }

    @Override
    public int height() {
        return maxHeight(this.root);
    }

    private int maxHeight(Node<T> root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxHeight(root.getLeft()), maxHeight(root.getRight())) + 1;
    }

    private T getMinNode(Node<T> node) {

        if (node.getLeft() != null) {

            return getMinNode(node.getLeft());
        }

        return node.getData();
    }
}
