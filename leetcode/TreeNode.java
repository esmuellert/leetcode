package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    private static int[] treeArray;

    public static TreeNode buildTreeFromArray(int[] array) {
        treeArray = array;
        return buildHelper(0);
    }

    private static TreeNode buildHelper(int index) {
        if (index > treeArray.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(treeArray[index]);
        root.left = buildHelper(2 * index + 1);
        root.right = buildHelper(2 * index + 2);
        return root;
    }


}
