package Bst;

public class ValidateBST {


    public static void main(String[] args) {
        Node<Integer> root = new Node<>(5);
        root.left = new Node<Integer>(6);
        root.right = new Node<Integer>(7);

        System.out.println(validateBST(root));

        root = new Node<>(3);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(4);

        System.out.println(validateBST(root));

        root = new Node<>(20);
        root.left = new Node<Integer>(15);
        root.right = new Node<Integer>(30);

        root.left.right = new Node<Integer>(18);

        root.right.right = new Node<Integer>(40);

        System.out.println(validateBST(root));
    }


    public static boolean validateBST(Node<Integer> root) {

        boolean leftAnswer = true;
        boolean rightAnswer = true;

        Node<Integer> left = root.left;

        Node<Integer> right = root.right;

        if (right!= null) {
             if (right.data.compareTo(root.data) > 0) {
                 leftAnswer = validateBST(root.right);
             }
             else {
                 leftAnswer = false;
             }
        }
        if (left != null) {
              if (left.data.compareTo(root.data) < 0) {
                  rightAnswer = validateBST(root.left);
              }
              else {
                  rightAnswer = false;
              }
        }

        if (left ==null && right == null) {
            return true;
        }

        return leftAnswer && rightAnswer;

    }


}
