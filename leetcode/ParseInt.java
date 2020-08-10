package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParseInt {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '.') {
            s = "0" + s;
        }
        if (s.charAt(s.length() - 1) == '.') {
            s = s + "0";
        }
        try {
            double result = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        ParseInt p = new ParseInt();
        assertTrue(p.isNumber(".1"));
    }
}
