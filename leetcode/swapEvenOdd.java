package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class swapEvenOdd {
    public int[] exchange(int[] nums) {
        int evenPtr = 0;
        int oddPtr = nums.length - 1;

        while (evenPtr < oddPtr) {
            if (nums[evenPtr] % 2 == 0 && nums[oddPtr] % 2 != 0) {
                int temp = nums[evenPtr];
                nums[evenPtr] = nums[oddPtr];
                nums[oddPtr] = temp;
            }
            evenPtr = nums[evenPtr] % 2 == 0? evenPtr : evenPtr + 1;
            oddPtr = nums[oddPtr] % 2 == 0 ? oddPtr - 1 : oddPtr;
        }
        return nums;
    }
    @Test
    public void test() {
        swapEvenOdd p = new swapEvenOdd();
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 3, 2, 4};
        assertEquals(Arrays.equals(p.exchange(a), b), true);
    }
}
