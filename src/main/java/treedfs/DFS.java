package treedfs;

import common.TreeNode;

public class DFS {


    public void dfs(TreeNode node) {

        System.out.println(node.val);
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }
    public static void main(String[] args) {

        TreeNode node = TreeNode.buildFromString("3,5,1,6,2,0,8,null,null,7,4");

        System.out.println(node);
        DFS dfs = new DFS();
        dfs.dfs(node);


    }
}
