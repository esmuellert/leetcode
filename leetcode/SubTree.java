package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class SubTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // Queue<leetcode.TreeNode> queue = new ArrayDeque<>();
        // queue.add(A);
        // while(queue.peek() != null) {
        //     leetcode.TreeNode top = queue.remove();
        //     if (top.val == B.val) {
        //         boolean res = compareTree(top, B);
        //         if (res) {
        //             return res;
        //         }
        //     }
        //     if (top.left != null) {
        //         queue.add(top.left);
        //     }
        //     if (top.right != null) {
        //         queue.add(top.right);
        //     }
        // }
        // return false;
        return compareTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compareTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && (compareTree(A.left, B.left) && compareTree(A.right, B.right));
    }

    // private boolean isLeaf (leetcode.TreeNode node) {
    //     return node.left == null && node.right == null;
    // }

    // private int numOfChild (leetcode.TreeNode node) {
    //     int counter = 2;
    //     if (node.left == null) {
    //         counter --;
    //     }
    //     if (node.right == null) {
    //         counter --;
    //     }
    //     return counter;
    // }

    @Test
    public void test() {
        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            array[i] = i;
        }
        TreeNode A = TreeNode.buildTreeFromArray(new int[]{1, 0, 1, 4, 3});
        TreeNode B = TreeNode.buildTreeFromArray(new int[]{1, 4});
        assertFalse(isSubStructure(A, B));
    }
}
