package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else {
                if (!stack.isEmpty()) {
                    int idx = stack.peek();
                    if (s.charAt(idx) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) {
            return s.length();
        }
        int max = 0;
        int a = s.length();
        while (!stack.isEmpty()) {
            int b = stack.pop();
            max = Math.max(max, a - b - 1);
            a = b;
        }
        max = Math.max(max, a);
        return max;
    }
}
