package Bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static Bst.BST.createTree;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
        int[] childrenA = {1, 4};
        int[] childrenB = {3, 8};
        int[] childrenC = {9, 2};
        int[] childrenD = {6, 7};

        mapping1.put(5, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(4, childrenC);
        mapping1.put(3, childrenD);

        Node<Integer> head1 = createTree(mapping1, 5);




        List<Integer> path1 = pathToX(head1, 8);
        List<Integer> path2 = pathToX(head1, 7);

        Collections.reverse(path1);
        Collections.reverse(path2);

        if (path1.size() == 0 || path2.size() ==0) {
            System.out.println("No path exists");
        }

        Iterator<Integer> iter1 = path1.iterator();
        Iterator<Integer> iter2 = path2.iterator();
        Integer temp = null;
        while(iter1.hasNext() && iter2.hasNext()) {
            Integer l1 = iter1.next();
            Integer l2 = iter2.next();
            if (l1 != l2) {
                System.out.println("Common ancestor is: " + temp);
            } else {
                temp = l1;
            }
        }
    }

    private static List<Integer>  pathToX(Node<Integer> head, int x) {

        List<Integer> path = new ArrayList<>();

        findPath(head, x, path);
        return path;
    }

    private static void findPath(Node<Integer> node, int x, List<Integer> path) {
        if(node == null) {
            return;
        }
        else if (node.getData() == x) {
            path.add(node.getData());
            return;
        }

        findPath(node.getLeftChild(), x, path);
        if (path.size() > 0) {
            path.add(node.getData());
            return;
        }
        findPath(node.getRightChild(), x , path);
        if (path.size() > 0) {
            path.add(node.getData());
            return;
        }

    }
}
