package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.push(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.pop();
                curr.add(node.val);
                if (node.left != null) {
                    queue2.push(node.left);
                }
                if (node.right != null) {
                    queue2.push(node.right);
                }
            }
            if (!curr.isEmpty()) {
                list.add(curr);
            }
            curr = new ArrayList<>();
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.pop();
                curr.add(node.val);
                if (node.right != null) {
                    queue1.push(node.right);
                }
                if (node.left != null) {
                    queue1.push(node.left);
                }
            }
            if (!curr.isEmpty()) {
                list.add(curr);
            }
        }
        return list;
    }
}
