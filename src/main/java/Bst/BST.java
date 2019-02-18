package Bst;

import java.util.HashMap;

public class BST {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        // The mapping we're going to use for constructing a tree.
        // For example, {0: [1, 2]} means that 0's left child is 1, and its right
        // child is 2.
        HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
        int[] childrenA = {1, 2};
        int[] childrenB = {3, 4};
        int[] childrenC = {5, 6};
        mapping1.put(0, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(2, childrenC);

        Node<Integer> head1 = createTree(mapping1, 0);
        // This tree is:
        // head1 = 0
        //        / \
        //       1   2
        //      /\   /\
        //     3  4 5  6


        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
        int[] childrenD = {1, 4};
        int[] childrenE = {0, 2};
        int[] childrenF = {5, 6};
        mapping2.put(3, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);

        Node<Integer> head2 = createTree(mapping2, 3);
        // This tree is:
        //  head2 = 3
        //        /   \
        //       1     4
        //      /\    / \
        //     0  2  5   6


        HashMap<Integer, int[]> mapping3 = new HashMap<Integer, int[]>();
        int[] childrenG = {1, 5};
        int[] childrenH = {0, 2};
        int[] childrenI = {4, 6};
        mapping3.put(3, childrenG);
        mapping3.put(1, childrenH);
        mapping3.put(5, childrenI);

        Node<Integer> head3 = createTree(mapping3, 3);
        // This tree is:
        //  head3 = 3
        //        /   \
        //       1     5
        //      /\    / \
        //     0  2  4   6



        HashMap<Integer, int[]> mapping4 = new HashMap<Integer, int[]>();
        int[] childrenJ = {1, 5};
        int[] childrenK = {0, 4};
        mapping4.put(3, childrenJ);
        mapping4.put(1, childrenK);

        Node<Integer> head4 = createTree(mapping4, 3);
        // This tree is:
        //  head4 = 3
        //        /   \
        //       1     5
        //      /\
        //     0  4


        System.out.println(isBST(head1)); //should return false
        System.out.println(isBST(head2)); // should return false
        System.out.println(isBST(head3)); // should return true
        System.out.println(isBST(head4)); // should return false
        System.out.println("isbalanced: " + isBalanced(head4));
    }



    // Implement your function below.
    public static boolean isBST(Node<Integer> node) {
        return isBstHelper(node, null, null);
    }

    public static boolean isBstHelper(Node<Integer> node, Integer lowerLim, Integer upperLim) {
        if (lowerLim != null && node.getData() < lowerLim) return false;
        if (upperLim != null && upperLim < node.getData()) return false;
        boolean isLeftBST = true;
        boolean isRightBST = true;
        if (node.getLeft() != null) {
            isLeftBST = isBstHelper(node.getLeft(), lowerLim, node.getData());
        }
        if (isLeftBST && node.getRight() != null) {
            isRightBST = isBstHelper(node.getRight(), node.getData(), upperLim);
        }
        return isLeftBST && isRightBST;
    }


    // A function for creating a tree.
    // Input:
    // - mapping: a node-to-node mapping that shows how the tree should be constructed
    // - headValue: the value that will be used for the head ndoe
    // Output:
    // - The head node of the resulting tree
    public static Node<Integer> createTree(HashMap<Integer, int[]> mapping, int headValue) {
        Node<Integer> head = new Node<>(headValue, null, null);
        HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
        nodes.put(headValue, head);
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            Node<Integer> leftChild = new Node<>(value[0], null, null);
            Node<Integer> rightChild = new Node<>(value[1], null, null);
            nodes.put(value[0], leftChild);
            nodes.put(value[1], rightChild);
        }
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            nodes.get(key).setLeft(nodes.get(value[0]));
            nodes.get(key).setRight(nodes.get(value[1]));
        }
        return head;
    }

    /* Returns true if binary tree with root as root is height-balanced */
    static boolean  isBalanced(Node node)
    {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (node == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = height(node.getLeft());
        rh = height(node.getRight());

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.getLeft())
                && isBalanced(node.getRight()))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }


}
