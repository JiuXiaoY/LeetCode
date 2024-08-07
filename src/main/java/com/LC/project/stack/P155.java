package com.LC.project.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/7
 */
public class P155 {
    public static void main(String[] args) {

    }

    class MinStack {
        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            // 只有当 minStack 为空或者 val 小于等于 minStack 的栈顶元素时，才将 val 压入 minStack
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            // 如果主栈的栈顶元素等于最小值栈的栈顶元素，则同步弹出最小值栈的栈顶元素
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.peek();
        }
    }

}
