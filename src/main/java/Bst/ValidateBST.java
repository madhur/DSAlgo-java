package Bst;

import javax.print.attribute.IntegerSyntax;

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

        root   = new Node<>(20);
        root.left = new Node<Integer>(15);
        root.right = new Node<Integer>(30);

        root.left.right = new Node<Integer>(18);

        root.right.right = new Node<Integer>(40);

        System.out.println(validateBST(root));


        root = new Node<>(20);
        root.left = new Node<Integer>(15);
        root.right = new Node<Integer>(40);
        root.left.left = new Node<Integer>(10);
        root.left.right = new Node<Integer>(30);



        System.out.println(validateBST(root));
    }


    /* Solution from firecode
    public static boolean validateBST(TreeNode root) {
        return validateBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        // left subtree must be < root.val && right subtree must be > root.val
        return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
    */


    public static boolean validateBST(Node<Integer> root) {

        boolean leftAnswer = true;
        boolean rightAnswer = true;

        Node<Integer> left = root.left;

        Node<Integer> right = root.right;

        if (right!= null) {
             if (right.data.compareTo(root.data) > 0) {
                 leftAnswer = validateRightBST(root.right, root.data);
             }
             else {
                 return false;
             }
        }
        if (left != null) {
              if (left.data.compareTo(root.data) < 0) {
                  rightAnswer = validateLeftBST(root.left, root.data);
              }
              else {
                  return false;
              }
        }

        if (left ==null && right == null) {
            return true;
        }

        return leftAnswer && rightAnswer;

    }

    private static boolean validateRightBST(Node<Integer> root, Integer data) {

        boolean leftAnswer = true;
        boolean rightAnswer = true;

        Node<Integer> left = root.left;

        Node<Integer> right = root.right;

        if (right!= null) {
            if (right.data.compareTo(root.data) > 0 && right.data > data) {
                leftAnswer = validateRightBST(root.right, root.data);
            }
            else {
                return false;
            }
        }
        if (left != null) {
            if (left.data.compareTo(root.data) < 0 && left.data > data) {
                rightAnswer = validateLeftBST(root.left, root.data);
            }
            else {
                return false;
            }
        }

        if (left ==null && right == null) {
            return true;
        }

        return leftAnswer && rightAnswer;

    }

    private static boolean validateLeftBST(Node<Integer> root, Integer data) {
        boolean leftAnswer = true;
        boolean rightAnswer = true;

        Node<Integer> left = root.left;

        Node<Integer> right = root.right;

        if (right!= null) {
            if (right.data.compareTo(root.data) > 0 && right.data < data) {
                leftAnswer = validateRightBST(root.right, root.data);
            }
            else {
                return false;
            }
        }
        if (left != null) {
            if (left.data.compareTo(root.data) < 0 && left.data < data) {
                rightAnswer = validateLeftBST(root.left, root.data);
            }
            else {
                return false;
            }
        }

        if (left ==null && right == null) {
            return true;
        }

        return leftAnswer && rightAnswer;
    }


}
