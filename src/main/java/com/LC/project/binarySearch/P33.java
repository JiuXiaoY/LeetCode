package com.LC.project.binarySearch;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/7
 */
public class P33 {
    public static void main(String[] args) {
        P33 p33 = new P33();
        System.out.println(p33.search(new int[]{3, 1}, 3));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid;

        // 找到旋转点（最小值的索引）
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left 是旋转点的索引
        int rotation = left;
        left = 0;
        right = n - 1;

        // 判断 target 应该在哪一部分
        if (target >= nums[rotation] && target <= nums[right]) {
            left = rotation;
        } else {
            right = rotation - 1;
        }

        // 在确定的范围内进行二分查找
        return binarySearch(nums, left, right, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
