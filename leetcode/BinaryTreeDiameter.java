package leetcode;

import org.junit.Test;
public class BinaryTreeDiameter {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        diameterHelper(root);
        return max;
    }

    private int diameterHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterHelper(root.left);
        int right = diameterHelper(root.left);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
    @Test
    public void test() {
        BinaryTreeDiameter btd = new BinaryTreeDiameter();
        TreeNode node = TreeNode.buildTreeFromArray(new int[]{1, 2, 3, 4, 5});
        btd.diameterOfBinaryTree(node);
        int i = -999999999;
        System.out.println(i % 10);
    }
}
