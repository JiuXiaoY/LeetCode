package com.LC.project.binarySearch;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/6
 */
public class P34 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }
}
