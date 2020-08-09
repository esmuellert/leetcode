package leetcode;

import org.junit.Test;

import java.util.ArrayList;

public class LastRemain {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        int length = m - 1;
        while (list.size() > 1) {
            while (length > 0) {
                i++;
                if (i >= list.size()) {
                    i = 0;
                }
                length--;
            }
            list.remove(i);
            if (i >= list.size()) {
                i = 0;
            }
            length = m - 1;
        }
        return list.get(0);
    }

    @Test
    public void test() {
        LastRemain lr = new LastRemain();
        lr.lastRemaining(5, 3);
        String s = "11111111111";
        try {
            Integer.parseInt(s);
        } catch (Exception NumberFormatException) {
        }
        System.out.println(('3' - '0'));
    }

}
