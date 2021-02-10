package common;

import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void treeTest() {
        TreeNode treeNode = TreeNode.buildFromString("3,5,1,6,2,0,8,null,null,7,4");
        System.out.println(treeNode);
    }
}
