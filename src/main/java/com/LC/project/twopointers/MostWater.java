package com.LC.project.twopointers;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class MostWater {
    public static void main(String[] args) {
        int[] height = {1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
