package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolish {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int first, second;
        for (String s : tokens) {
            switch (s) {
                case "+": {
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first + second);
                    break;
                }
                case "-": {
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                }
                case "*": {
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first * second);
                    break;
                }
                case "/": {
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        assert stack.peek() != null;
        return stack.peek();
    }

    public static void main(String[] args) {
        ReversePolish rp = new ReversePolish();
        System.out.println(rp.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
