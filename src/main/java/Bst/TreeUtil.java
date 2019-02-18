package Bst;

public class TreeUtil<T extends Comparable<T>> {

    public void traversal(Node<T> root) {

        if(root != null) {
            inOrderTraversal(root);
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

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(20);
        root.setLeft(new Node<>(8));
        root.setRight(new Node<>(22));
        root.getLeft().setLeft(new Node<>(4));
        root.getLeft().setRight(new Node<>(12));


    }
}
