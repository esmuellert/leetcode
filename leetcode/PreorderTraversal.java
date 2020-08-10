package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    // private List<Integer> res;
    // public List<Integer> preorderTraversal(leetcode.TreeNode root) {
    //     res = new ArrayList<>();
    //     preorderHelper(root);
    //     return res;
    // }
    // private void preorderHelper(leetcode.TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     res.add(root.val);
    //     preorderHelper(root.left);
    //     preorderHelper(root.right);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.left == null && curr.right != null) {
                stack.push(curr.right);
            } else if (curr.right == null && curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null && curr.left != null) {
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return res;
    }

    @Test
    public void test() {
        PreorderTraversal pt = new PreorderTraversal();
        pt.preorderTraversal(TreeNode.buildTreeFromArray(new int[]{1, 2, 3}));
    }
}
