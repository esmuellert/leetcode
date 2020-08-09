package leetcode;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class levelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        res.add(root.val);
        while (queue.peek() != null) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.offer(node.left);
                res.add(node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                res.add(node.right.val);
            }
        }
        // return res.stream().mapToInt(Integer::valueOf).toArray();
        int[] result = new int[res.size()];
        int index = 0;
        for (int i : res) {
            result[index++] = i;
        }
        return result;
    }

//    List<List<Integer>> res;
//    public List<List<Integer>> leetcode.levelOrder(leetcode.TreeNode root) {
//        if (root == null) {
//            List<List<Integer>> list = new ArrayList<>();
//            return list;
//        }
//        res = new ArrayList<>();
//        levelOrderHelper(root, 0);
//        return res;
//    }
//
//    private void levelOrderHelper(leetcode.TreeNode node, int height) {
//        if (node == null) {
//            return;
//        }
//        if (res.size() <= height) {
//            res.add(new ArrayList<Integer>());
//        }
//        List<Integer> list = res.get(height);
//        list.add(node.val);
//        levelOrderHelper(node.left, height + 1);
//        levelOrderHelper(node.right, height + 1);
//    }


}
