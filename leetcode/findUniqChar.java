package leetcode;

import java.util.HashMap;

public class findUniqChar {
    //    public char firstUniqChar(String s) {
//        int[] frequency = new int[26];
//        int rank = 1;
//        HashMap<Integer, Integer> appear = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            frequency[(int) c - 97]++;
//            if (!appear.containsKey((int) c - 97)) {
//                appear.put((int) c - 97, rank);
//                rank++;
//            }
//        }
//        int appearRank = 27;
//        int res = 0;
//        for (int i = 0; i < 26; i++) {
//            if (frequency[i] == 1) {
//                if (appear.get(i) < appearRank) {
//                    res = i;
//                    appearRank = appear.get(i);
//                }
//            }
//        }
//        if (appearRank == 27) {
//            return ' ';
//        }
//
//        return (char) (res + 97);
//    }
    public char firstUniqChar(String s) {
        int[] frequency = new int[26];
        int[] appear = new int[26];
        int rank = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency[((int) c) - 97]++;
            if (appear[((int) c) - 97] == 0) {
                appear[((int) c) - 97] = rank;
                rank++;
            }
        }
        int appearRank = 27;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1) {
                appearRank = Math.min(appearRank, appear[i]);
            }
        }
        if (appearRank == 27) {
            return ' ';
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (appear[i] == appearRank) {
                res = i;
                break;
            }
        }
        return (char) (res + 97);
    }

}
