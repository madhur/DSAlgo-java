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
        System.out.println("");
        System.out.println("Height of tree is : " + bst.height());

        Node<Integer> root = createTreeFromArray(new Integer[]{1, 2, 3, 4, 5, 6,7,8,9});

        new BTreePrinter().printNode(root);

    }

    public static Node<Integer> createTreeFromArray(Integer[] sortedArray) {

      return addToTree(sortedArray, 0, sortedArray.length - 1);

    }

    private static Node<Integer> addToTree(Integer[] sortedArray, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end ) / 2;
        Node<Integer> rootNode = new Node<>(sortedArray[mid]);
        rootNode.setLeft(addToTree(sortedArray, start, mid - 1));
        rootNode.setRight(addToTree(sortedArray, mid+1, end));
        return rootNode;
    }
}
