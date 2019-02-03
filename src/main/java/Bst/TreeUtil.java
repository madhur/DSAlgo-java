package Bst;

public class TreeUtil<T> {

    public void traversal(Node<T> root) {

        if(root != null) {
            inOrderTraversal(root);
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

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(20);
        root.setLeftChild(new Node<>(8));
        root.setRightChild(new Node<>(22));
        root.getLeftChild().setLeftChild(new Node<>(4));
        root.getLeftChild().setRightChild(new Node<>(12));


    }
}
