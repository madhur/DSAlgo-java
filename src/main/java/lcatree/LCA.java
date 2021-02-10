package lcatree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCA {

    boolean isSamePath = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        findNode(root, p, path1);
        findNode(root, q, path2);

        int i = 0;
        int j = 0;


        while (i < path1.size() && j < path2.size()) {
            if (path1.get(i) == path2.get(j)) {

                i++;
                j++;
            } else {

                break;
            }
        }

        return path1.get(i - 1);
    }

    private boolean findNode(TreeNode node, TreeNode n, List<TreeNode> path) {
        path.add(node);


        if (node.val == n.val) {

            return true;
        }

        if (node.left != null) {
            return findNode(node.left, n, path);
        }
        if (node.right != null) {
            return findNode(node.right, n,  path);
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        LCA lca = new LCA();

    }
}
