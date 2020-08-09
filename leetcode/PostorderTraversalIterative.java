package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversalIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || (res.size() != 0 && res.get(res.size() - 1) == node.right.val)) {
                res.add(node.val);
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return res;
    }
    @Test
    public void test() {
        PostorderTraversalIterative pti = new PostorderTraversalIterative();
        pti.postorderTraversal(TreeNode.buildTreeFromArray(new int[]{1,2,3}));
    }
}
