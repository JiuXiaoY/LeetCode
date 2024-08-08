package com.LC.project.stack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/8
 */
public class P84 {
    public static void main(String[] args) {

    }

    // 思路：关键是 找到以每一个柱子为高的所能延伸的最大矩形面积
    // 以每一个柱子为高，向两边延伸，找到第一个小于当前柱子高度的左右边界
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);
        Deque<Integer> monoStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                right[monoStack.peek()] = i;
                monoStack.pop();
            }
            left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
