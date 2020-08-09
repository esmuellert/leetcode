package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            clearOneQueue(list, queue1, queue2, curr);
            curr = new ArrayList<>();
            clearOneQueue(list, queue2, queue1, curr);
        }
        return list;
    }

    private void clearOneQueue(List<List<Integer>> list, Queue<TreeNode> queue1, Queue<TreeNode> queue2, List<Integer> curr) {
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.remove();
            curr.add(node.val);
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }
        }
        if (!curr.isEmpty()) {
            list.add(curr);
        }
    }

}
