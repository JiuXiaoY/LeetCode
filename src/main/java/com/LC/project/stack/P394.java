package com.LC.project.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/8
 */
public class P394 {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new P394().decodeString(s));
    }

    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();

                StringBuilder times = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    times.append(stack.pop());
                }
                int num = Integer.parseInt(times.reverse().toString());
                for (int j = 0; j < num; j++) {
                    for (int k = sb.length() - 1; k >= 0; k--) {
                        stack.push(sb.charAt(k));
                    }
                }
            } else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
