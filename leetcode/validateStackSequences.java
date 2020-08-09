package leetcode;

import java.util.Stack;
public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // HashMap<Integer, Integer> pop = new HashMap<>();
        // for (int i = 0; i < popped.length; i++) {
        //     pop.put(popped[i], i);
        // }
        // for (int i = 2; i < pushed.length; i++) {
        //     int check = pushed[i];
        //     int checkPoppedIndex = pop.get(check);
        //     int prevPoppedIndex = pop.get(pushed[i - 1]);
        //     if (checkPoppedIndex < prevPoppedIndex) {
        //         for (int j = 0; j < i - 1; j++) {
        //             int poppedIndex = pop.get(pushed[j]);
        //                 if (poppedIndex > checkPoppedIndex && poppedIndex < prevPoppedIndex) {
        //                     return false;
        //                 }
        //         }
        //     }

        // }
        // return true;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int poppedIndex = 0;
        while (true) {
            if (pushIndex == poppedIndex && pushIndex == pushed.length) {
                return true;
            }
            if (pushIndex == pushed.length && stack.peek() != popped[poppedIndex]) {
                return false;
            }
            if (!stack.empty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            } else if (pushIndex < pushed.length) {
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }
        }
    }
}
