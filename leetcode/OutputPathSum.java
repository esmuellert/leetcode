package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OutputPathSum {
    private List<List<Integer>> res;
    private List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        pathHelper(root, sum);
        return res;
    }

    private void pathHelper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            list.add(root.val);
            res.add(list);
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        pathHelper(root.left, sum - root.val);
        pathHelper(root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
    @Test
    public void test() {
        OutputPathSum ops = new OutputPathSum();
        ops.pathSum(TreeNode.buildTreeFromArray(new int[]{5,4,8,11,0,13,4,7,2,0,0,5,1}), 22);
    }
}
