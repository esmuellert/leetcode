package leetcode;

public class InverseBinaryTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }
}
