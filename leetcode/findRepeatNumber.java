package leetcode;

import java.util.HashSet;
import java.util.Set;

public class findRepeatNumber {
    public int finder(int[] nums) {
//        Set<Integer> numbers = new HashSet<Integer>();
//        for (int i = 0; i < nums.length ; i++) {
//            boolean result = numbers.add(nums[i]);
//            if (result == false) {
//                return nums[i];
//            }
//        }
//        return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            } else if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                int current = nums[i];
                nums[i] = nums[nums[i]];
                nums[current] = current;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int[] num = {2, 3, 1, 0, 2, 5, 3};
//        leetcode.findRepeatNumber frn = new leetcode.findRepeatNumber();
//        frn.finder(num);
//    }
}
