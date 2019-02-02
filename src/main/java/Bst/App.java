package Bst;

public class App {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(32);
        bst.insert(10);
        bst.insert(1);
        bst.insert(19);
        bst.insert(16);
        bst.insert(23);
        bst.insert(55);
        bst.insert(79);

        System.out.println(bst.getMax());
        System.out.println(bst.getMin());

        bst.traversal();

    }
}
