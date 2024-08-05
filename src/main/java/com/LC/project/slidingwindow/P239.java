package com.LC.project.slidingwindow;

import java.util.*;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class P239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindowAI(nums, 3)));
    }

    // 超时
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> window = new PriorityQueue<>(k, Comparator.reverseOrder());
        int count = 0;
        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
        }
        for (int i = k; i <= nums.length; i++) {
            res[i - k] = window.peek();
            window.remove(nums[count++]);
            if (i < nums.length) {
                window.add(nums[i]);
            }
        }
        return res;
    }

    public static int[] maxSlidingWindowAI(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 移除队列中比当前元素小的所有元素，因为它们不可能成为接下来窗口的最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            // 添加当前元素的索引
            deque.addLast(i);
            // 如果队列头部的元素已经不在当前窗口中，移除它
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            // 当窗口大小达到k时，记录最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
