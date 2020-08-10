package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int border = -1;
        if (nums.length == 0 || nums[0] > 0) {
            return res;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] <= 0 && nums[i + 1] >= 0) {
                    border = i;
                    break;
                }
            }
            if (border < 0) {
                return res;
            }
        }
        while (border + 1 < nums.length && nums[border + 1] == nums[border]) {
            border++;
        }
        int first = 0;
        int mid = 1;
        int last = nums.length - 1;
        while (first < border && mid < last) {
            if (nums[first] + nums[mid] + nums[last] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[first]);
                list.add(nums[mid]);
                list.add(nums[last]);
                res.add(list);
                mid++;
                last--;
                while (mid < nums.length && nums[mid - 1] == nums[mid]) {
                    mid++;
                }
                while (last > first && nums[last + 1] == nums[last]) {
                    last--;
                }
            } else if (nums[first] + nums[mid] + nums[last] > 0) {
                last--;
            } else if (nums[first] + nums[mid] + nums[last] < 0) {
                mid++;
            }

            if (mid >= last) {
                first++;
                while (first < border && nums[first] == nums[first - 1]) {
                    first++;
                }
                mid = first + 1;
                last = nums.length - 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
//        leetcode.ThreeSum ts = new leetcode.ThreeSum();
//        ts.threeSum(new int[]{-1,0, 1});
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(array, 0, array, 4, 9);
        System.out.println(array.toString());
    }
}
