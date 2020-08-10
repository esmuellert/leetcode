package leetcode;

import org.junit.Test;

public class SingleNumberInThree {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        int bitOne = 1;
        for (int num : nums) {
            bitOne = 1;
            for (int i = 0; i < 32; i++) {
                if ((num & bitOne) != 0) {
                    counts[i]++;
                }
                bitOne <<= 1;
            }
        }
        int res = 0;
        bitOne = 1;
        for (int count : counts) {
            if (count % 3 != 0) {
                res |= bitOne;
            }
            bitOne <<= 1;
        }
        return res;
    }

    @Test
    public void test() {
        SingleNumberInThree snit = new SingleNumberInThree();
        snit.singleNumber(new int[]{3, 4, 3, 3});
        int a = 1;
        int b = 2;
        double c = a / b;
        double d = b;
//        assertTrue(((c + 1 / b) % 1) == 0);
        StringBuilder s = new StringBuilder("1234567890");
        StringBuilder strs = s.delete(0, 1);
        System.out.println(d);
    }
}
