package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
    TreeNode(int x) { val = x; }

    public static TreeNode buildFromString(String str) {
        String[] nodes = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i< nodes.length) {
            node = queue.poll();
            node.left = getNode(nodes[i]);
            node.right = getNode(nodes[i+1]);
            if(node.left != null) {
               queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            i = i + 2;
        }
        return root;
    }

    private static TreeNode getNode(String val) {
        if ("null".equalsIgnoreCase(val)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }

    @Override
    public String toString() {
        BTreePrinter.printNode(this);
        return String.valueOf(this.val);
    }
}
