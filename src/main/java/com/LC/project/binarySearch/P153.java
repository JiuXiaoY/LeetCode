package com.LC.project.binarySearch;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/7
 */
public class P153 {
    public static void main(String[] args) {
        P153 p153 = new P153();
        System.out.println(p153.findMin(new int[]{1,2}));
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // 找到旋转点（最小值的索引）
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
