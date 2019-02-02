package Bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

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

        if(node.getLeftChild()!=null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node + " - ");

        if(node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }

    }


    private void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {
            if ( node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }

        } else {
            if ( node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    @Override
    public void delete(T data) {


    }

    private Node<T> deleteNode(Node<T> node, T data) {
        if (node == null) return node;

        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(deleteNode(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(deleteNode(node.getRightChild(), data));
        } else {
            if(node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a left node...");
                return null;
            }

            if (node.getLeftChild() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            } else if(node.getRightChild() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }

            // this is the node with two children case !!!

            System.out.println("Removing item with two children...");
            Node<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData());
            node.setLeftChild(deleteNode(node.getLeftChild(), tempNode.getData()));

        }


        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null)
            return getPredecessor(node.getRightChild());

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

        if (node.getRightChild() != null) {

            return getMaxNode(node.getRightChild());
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

    private T getMinNode(Node<T> node) {

        if (node.getLeftChild() != null) {

            return getMinNode(node.getLeftChild());
        }

        return node.getData();
    }
}
