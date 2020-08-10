package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringPermutation {
    private char[] ch;
    private List<String> list;

    public String[] permutation(String s) {
        ch = s.toCharArray();
        list = new ArrayList<>();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    private void dfs(int fixed) {
        if (fixed == ch.length) {
            list.add(String.valueOf(ch));
        } else {
            HashSet<Character> set = new HashSet<>();
            for (int i = fixed; i < ch.length; i++) {
                if (set.contains(ch[i])) {
                    continue;
                }
                set.add(ch[i]);
                swap(fixed, i);
                dfs(fixed + 1);
                swap(fixed, i);
            }
        }
    }

    private void swap(int x, int y) {
        char temp = ch[x];
        ch[x] = ch[y];
        ch[y] = temp;
    }

    @Test
    public void test() {
        StringPermutation sp = new StringPermutation();
        sp.permutation("aab");
    }
}
