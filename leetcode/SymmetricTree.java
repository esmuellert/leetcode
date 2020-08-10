package leetcode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return symmetricHelper(root, root);
    }

    private boolean symmetricHelper(TreeNode A, TreeNode B) {
        if (!(A == null && B == null) && !(A != null && B != null)) {
            return false;
        }
        return A == null && B == null || A.val == B.val
                && symmetricHelper(A.left, B.right) && symmetricHelper(A.right, B.left);
    }
}
