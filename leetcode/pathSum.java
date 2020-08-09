package leetcode;

import java.util.List;
import java.util.ArrayList;

public class pathSum {
    // private List<List<Integer>> res;
    // private int SUM;
    // public List<List<Integer>> leetcode.pathSum(leetcode.TreeNode root, int sum) {
    //     res = new ArrayList<>();
    //     SUM = sum;
    //     if (root == null) {
    //         return res;
    //     }
    //     return sumHelper(root, 0);
    // }

    // private boolean isLeaf (leetcode.TreeNode node) {
    //     return node.left == null && node.right == null;
    // }

    // private List<List<Integer>> sumHelper(leetcode.TreeNode node, int sum) {
    //     if (node == null) {
    //         return null;
    //     }
    //     if (sum + node.val == SUM && isLeaf(node)) {
    //         List<Integer> list = new ArrayList<>();
    //         List<List<Integer>> listOfList = new ArrayList<>();
    //         list.add(node.val);
    //         listOfList.add(list);
    //         return listOfList;
    //     }
    //     List<List<Integer>> left, right, res;
    //     left = sumHelper(node.left, sum + node.val);
    //     right = sumHelper(node.right, sum + node.val);
    //     if (left == null && right == null) {
    //         res = new ArrayList<>();
    //     } else if (left == null) {
    //         res = right;
    //     } else if (right == null) {
    //         res = left;
    //     } else {
    //         left.addAll(right);
    //         res = left;
    //     }
    //     if (!res.isEmpty()) {
    //         for (List<Integer> l : res) {
    //             l.add(0, node.val);
    //         }
    //     }
    //     return res;

    // }
    private List<List<Integer>> res;
    private int SUM;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        SUM = sum;
        if (root == null) {
            return res;
        }
        List<Integer> subList = new ArrayList<>();
        sumHelper(root, 0, subList);
        return res;
    }

    private boolean isLeaf (TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void sumHelper(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (sum + node.val == SUM && isLeaf(node)) {
            res.add(new ArrayList<>(list));
        } else {
            sumHelper(node.left, sum + node.val, list);
            sumHelper(node.right, sum + node.val, list);
        }
        list.remove(list.size() - 1);
    }
}
