package com.LC.project.binarySearch;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/6
 */
public class P35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new P35().searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[left] < target ? left + 1 : left;
    }

}
