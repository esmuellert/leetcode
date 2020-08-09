package leetcode;

import java.util.HashMap;

public class rebuildBinaryTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] p;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int last = preorder.length - 1;
        if (last == -1) {
            return null;
        }
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        p = preorder;
        return buildHelper(0, last, 0, last);
    }

//    private int search(int[] array, int goal) {
//        int result = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (goal == array[i]) {
//                result = i;
//                break;
//            }
//        }
//        return result;
//    }

    private TreeNode buildHelper(int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode root = new TreeNode(p[preStart]);
        if (preEnd == preStart) {
            return new TreeNode(p[preStart]);
        } else {
            int inorderIndex = map.get(p[preStart]);
            int leftSize = inorderIndex - inStart;
            int rightSize = inEnd - inorderIndex;
            int leftPreStart = preStart + 1;
            int leftPreEnd = preStart + leftSize;
            int leftInStart = inStart;
            int leftInEnd = inStart + leftSize - 1;

            int rightPreStart = leftPreEnd + 1;
            int rightPreEnd = rightPreStart + rightSize - 1;
            int rightInStart = leftInEnd + 2;
            int rightInEnd = rightInStart + rightSize - 1;
            if (leftSize == 0) {
                root.left = null;
            } else {
                root.left = buildHelper(leftPreStart, leftPreEnd, leftInStart, leftInEnd);
            }
            if (rightSize == 0) {
                root.right = null;
            } else {
                root.right = buildHelper(rightPreStart, rightPreEnd, rightInStart, rightInEnd);
            }
            return root;
        }
    }

//    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
//        leetcode.rebuildBinaryTree r = new leetcode.rebuildBinaryTree();
//        leetcode.TreeNode tree = r.buildTree(preorder, inorder);
//    }


}
