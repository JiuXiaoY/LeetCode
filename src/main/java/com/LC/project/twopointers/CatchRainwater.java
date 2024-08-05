package com.LC.project.twopointers;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class CatchRainwater {
    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        // 左右两边第一个不可能装水
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum += min - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum += min - height[right];
                }
                right--;
            }
        }

        return sum;
    }
}
